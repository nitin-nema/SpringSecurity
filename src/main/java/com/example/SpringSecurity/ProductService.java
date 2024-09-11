package com.example.SpringSecurity;

@Service
public class ProductService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Product createProduct(Product product) {
        // Logic to create product
        return product;
    }

    @Secured("ROLE_ADMIN")
    public Product createProduct(Product product) {
        // Logic to create product
        return product;
    }
}


//---------------

protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated() // protect all other routes
            .and()
            .formLogin();
}