package com.mia.shopping;

import com.mia.DaOinterface.ConnectionDAO;
import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void saveProduct(List<Product> productList) throws SQLException {
        Connection connection = ConnectionDAO.getConnection();

        for (Product product : productList) {
            String sqlQuery = "INSERT INTO products(productname,description,quantity) " +
                    "VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getQuantity());

            int affectedRows = ps.executeUpdate();
            System.out.println(affectedRows + " row(s) affected !!");
        }
    }

    public static List<Product> getAllProducts() throws SQLException {
        Connection con = ConnectionDAO.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM products");
        ArrayList<Product> products = new ArrayList<Product>();

        while (rs.next()){
            Product product = new Product();
            product.setProductName(rs.getString("productname"));
            product.setDescription(rs.getString("description"));
            product.setQuantity(rs.getInt("quantity"));
            products.add(product);
        }
        return products;
    }

    public static boolean updateProduct(Product product, int id) throws SQLException {
        Connection con = ConnectionDAO.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE products " +
                "set productname = ?, description = ?, quantity = ? WHERE id = ? ");

        ps.setString(1, product.getProductName());
        ps.setString(2, product.getDescription());
        ps.setInt(3, product.getQuantity());
        ps.setInt(4, id);

        int i = ps.executeUpdate();
        if(i == 1){
            return true;
        }
        return false;
    }

    public static boolean deleteProduct(int id) throws SQLException {
        Connection con = ConnectionDAO.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id = ?");
        ps.setInt(1, id);
        int i = ps.executeUpdate();
        if(i == 1){
            return true;
        }
        return false;
    }



    public static void main(String[] args) throws SQLException {

            Product product1 = new Product("Phone", "Samsung galaxy Note II",
                    100);
            Product product2 = new Product("Charger",
                    "World famous Apple Charger", 50);
            Product product3 = new Product("Wired Cables", "USB C charger cables",
                    125);
            Product product4 = new Product("Head phones", "Boss Headset",
                    30);

            Inventory stock1 = new Inventory();
            stock1.addProduct(product1);
            stock1.addProduct(product2);
            stock1.addProduct(product3);
            stock1.addProduct(product4);

            // Inserting into our products table
//            Main.saveProduct(stock1.getProducts());

        // Get all products from the products table
//        for(Product product: Main.getAllProducts()){
//            System.out.println(product.getProductName() + " " + product. getDescription() + " "
//            + product.getQuantity());
//        }


        // Update product from products table
//        product1.setQuantity(500);
//        Main.updateProduct(product1, 1);

        // Delete product from the products table
        Main.deleteProduct(4);



//            System.out.println("Before Shopping: ");
//            System.out.println("The remaining quantity for " + product1.getProductName()
//                    + " is " + product1.getQuantity());
//            System.out.println("The remaining quantity for " + product3.getProductName()
//                    + " is " + product3.getQuantity());
//            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
//            List<Product> myProducts = new ArrayList<Product>();
//            myProducts.add(product1);
//            myProducts.add(product2);
//            myProducts.add(product3);

//            for (Product product : myProducts) {
//                System.out.print(product.getProductName() + "(" + product.getQuantity() + ")" + ", \n");
//            }
//            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
//            Order order1 = new Order(2, product1);
//            product1.setQuantity(order1.updateProductQuantity());
//
//            System.out.println("After shopping: ");
//            System.out.println("The remaining quantity for " + product1.getProductName()
//                    + " is " + product1.getQuantity());
//            Order order3 = new Order(2, product3);
//            product3.setQuantity(order3.updateProductQuantity());
//
//            System.out.println("The remaining quantity for " + product3.getProductName()
//                    + " is " + product3.getQuantity());

//        stock1.removeProduct(order1.getProduct());
//        stock1.removeProduct(order3.getProduct());

//        System.out.println("After shopping: " + stock1.getProductSize());


        }
}
