package com.qf.ww.dao.impl;

import com.qf.ww.dao.IProductDao;
import com.qf.ww.entity.Product;
import com.qf.ww.utils.DBManager;
import com.qf.ww.utils.DateUtils;
import com.qf.ww.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> getProductByCid(int cid) {
        List<Product> list = DBManager.commonQuery("select * from product where cid=?", Product.class, cid);
        return list;
    }

    @Override
    public List<Product> getPageByCid(int cid, int offset, int pageSize) {
        List<Product> list = DBManager.commonQuery("select * from product where cid=? limit ?,?", Product.class, cid, offset, pageSize);
        return list;
    }

    @Override
    public int getTotalCountByCid(int cid) {
        Integer count = DBManager.commonCount("select count(*) from product where cid=?",cid);
        return count;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> list = DBManager.commonQuery("select * from product", Product.class);
        return list;
    }

    @Override
    public List<Product> getPage(int offset, int pageSize) {
        List<Product> list = DBManager.commonQuery("selec * from product limit ?,?", Product.class, offset, pageSize);
        return list;
    }

    @Override
    public int getTotalCount() {
        Integer count = DBManager.commonCount("select count(*) from product ");
        return count;
    }

    @Override
    public int addProduct(Product product) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            connection = DruidUtils.getConnection();
            ps =connection.prepareStatement("insert into product(name,subTitle,price,stock,cid,createDate,imgUrl) value (?,?,?,?,?,?,?)");
            ps.setString(1,product.getName());
            ps.setString(2,product.getSubTitle());
            ps.setFloat(3,product.getPrice());
            ps.setInt(4,product.getStock());
            ps.setInt(5,product.getCid());
            ps.setTimestamp(6,DateUtils.d2t(product.getCreateDate()));
            ps.setString(7,product.getImgUrl());
            rSet = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.closeAll(ps,connection);
        }
        return rSet;
    }

    @Override
    public int deleteProduct(int id) {
        Integer rSet = DBManager.commonUpdate("delete from product where id=?", id);
        return rSet;
    }



/*    @Override
    public List<Product> getProductByCid(int cid) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Product> list = new ArrayList<>();
        Product product;

        try {
            connection = DruidUtils.getConnection();
            ps=connection.prepareStatement("select * from product where cid=?");
            ps.setInt(1,cid);
            rSet = ps.executeQuery();
            while (rSet.next()){
                int id = rSet.getInt(1);
                String name = rSet.getString(2);
                String subTitle = rSet.getString(3);
                float price = rSet.getFloat(4);
                int stock = rSet.getInt(5);
                *//*int cid = rSet.getInt(6);*//*
                Timestamp timestamp = rSet.getTimestamp(7);
                Object object = rSet.getObject(7);
                Date createDate = DateUtils.t2d(rSet.getTimestamp(7));
                String imgUrl = rSet.getString(8);
                product=new Product(id,name,subTitle,price,stock,cid,createDate,imgUrl);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.closeAll(rSet,ps,connection);
        }
        return list;
    }*/
}
