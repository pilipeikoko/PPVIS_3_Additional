package org.bsuir.ppvis.controller.command.impl;

import org.bsuir.ppvis.controller.command.Command;
import org.bsuir.ppvis.model.Product;
import org.bsuir.ppvis.model.UserContext;
import org.bsuir.ppvis.view.MainFrame;

public class AddProduct implements Command {
    @Override
    public void execute(MainFrame frame, UserContext context) {
        context.getUser().addProduct(new Product(frame.getProductName()), frame.getProductAmount());
        frame.showForMain();
    }
}
