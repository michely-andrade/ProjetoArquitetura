package one.digitalinnovation.experts.productcatalog.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Document(indexName = "product", type = "catalog")
public class Product {
    @Id
    private Long id;
    private String name;
    private Integer amount;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }
}
