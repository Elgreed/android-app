package com.geekbrains.geekbrainsprogect.data.database.room.dao;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.geekbrains.geekbrainsprogect.data.model.entity.Contractor;
import com.geekbrains.geekbrainsprogect.data.model.entity.ProductTransaction;
import com.geekbrains.geekbrainsprogect.data.model.entity.User;
import com.geekbrains.geekbrainsprogect.data.model.interf.IProductTransactions;
import com.geekbrains.geekbrainsprogect.data.model.interf.IUser;

public class ProductTransactionData implements IProductTransactions {
    @Embedded
    ProductTransaction productTransaction;
    @Relation(
            parentColumn = "contractor_id",
            entityColumn = "contractorId"
    )
    Contractor contractor;
    @Relation(
            parentColumn = "user_id",
            entityColumn = "userId"
    )
    User user;

    public ProductTransactionData(ProductTransaction productTransaction, Contractor contractor) {
        this.productTransaction = productTransaction;
        this.contractor = contractor;
    }

    public ProductTransaction getProductTransaction() {
        return productTransaction;
    }

    public void setProductTransaction(ProductTransaction productTransaction) {
        this.productTransaction = productTransaction;
    }

    @Override
    public long getId() {
        return productTransaction.getId();
    }

    public Contractor getContractor() {
        return contractor;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public String getDate() {
        return productTransaction.getDate();
    }

    @Override
    public double getQuantity() {
        return productTransaction.getQuantity();
    }

    @Override
    public String getComment() {
        return productTransaction.getComment();
    }

    @Override
    public long getProductId() {
        return productTransaction.getProductId();
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
