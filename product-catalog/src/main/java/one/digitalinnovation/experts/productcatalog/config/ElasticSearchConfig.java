package one.digitalinnovation.experts.productcatalog.config;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.actuate.autoconfigure.metrics.export.elastic.ElasticProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.swing.text.html.parser.Entity;

@Configuration
@EnableElasticsearchRepositories(basePackages = "one.digitalinnovation.experts.productcatalog.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient () {
        ClientConfiguration clienteConfiguration = ClientConfiguration.bulder()
                .connectedTo("localhost:9200", "localhost:9300")
                .build();
        return RestClient.create(clienteConfiguration).rest();

        @Bean
        @Override
        public EntityMapper entityMapper() {
            ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(elasticsearchMappingContext(),
                    new DefaultConversionService());
            entityMapper.setConversions(elasticsearchCustomConversions());

            return entityMapper;
        }
    }
}
