package vincere.etl.config.routing;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import vincere.etl.entity.vinc.AccountantEmail;

import javax.persistence.Entity;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.EnumSet;

@Component("vincereRoutingTestUtil")
@PropertySource("classpath:application-datasources-vincere.properties")
public class VincereRoutingTestUtil {

    public void createDatabase(String url, String username, String password, String dialect) throws Exception {
        Connection connection = DriverManager.getConnection(url, username, password);

        MetadataSources metadata = new MetadataSources(
            new StandardServiceRegistryBuilder()
                .applySetting("hibernate.dialect",dialect)
                .applySetting("javax.persistence.schema-generation-connection", connection)
                .applySetting(Environment.HBM2DDL_AUTO, "update").build());

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));

        for (BeanDefinition def : scanner.findCandidateComponents(AccountantEmail.class.getPackage().getName())) {
            metadata.addAnnotatedClass(Class.forName(def.getBeanClassName()));
        }

        Metadata mtd = metadata.buildMetadata();

        File tempFile = null;
        tempFile = new File("target/dbscript/vincere_schema.sql");
        new SchemaExport()
                .setOutputFile(tempFile.getAbsolutePath())
                .setFormat(false)
                .createOnly(EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT), mtd);

//        SchemaExport export = new SchemaExport((MetadataImplementor) metadata.buildMetadata(), connection);
//        export.create(true, true);
    }
}
