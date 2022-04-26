/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uk.ac.tees.scedt.b1349506.gui;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import uk.ac.tees.scedt.b1349506.ASCStockInterface;

import uk.ac.tees.scedt.b1349506.ASCStockItem;
import uk.ac.tees.scedt.b1349506.MSMStockItem;
import uk.ac.tees.scedt.b1349506.MeganAdapter;
import uk.ac.tees.scedt.b1349506.Observer;
import uk.ac.tees.scedt.b1349506.TransactionHistory;


/** Represents an Ashers’ Sport Collective stock item.
 * @author Omonkhodion Godswill - B1349506
 * @version 1.0
 * @since 1.0
 */

public class StockItemForm extends javax.swing.JFrame implements Observer{
    PrintWriter output = null;
    StringBuilder sBuilder = new StringBuilder();

    File stockItemFile = new File("./assets/_AshersSportsCollective.csv");
    File stockItemSoldFile = new File("./assets/AshersSportsCollectiveSold.csv");
    private static List<TransactionHistory> allTransactionHistory = TransactionHistory.loadModuleCSV();
    private static List<ASCStockItem> allASCStockItem = ASCStockItem.loadASCStockItemCSV();
    
   
    
    private static List<MSMStockItem> allMeganStockItem = MSMStockItem.loadStock();
    private static List<MeganAdapter> allMeganAdaptedStockItem = new ArrayList<>();

//    adapteMsmStockItems(allMeganStockItem, allMeganAdaptedStockItem);

    private static List<ASCStockInterface> allStockItems = new ArrayList<>();
    

    /**
     * Creates new form StockItemForm
     */
    public StockItemForm() {
        initComponents();
        
        
        adapteMsmStockItems();
        stockItemTable.setModel(new StockItemModel(allStockItems));
        transactionHistoryTable.setModel(new TransactionHistoryModel(allTransactionHistory));
        confirmCloseAction();
        fnRegisterObservers();
    }
    
    private void fnRegisterObservers() {
        for (ASCStockInterface stocks : allStockItems) {
         stocks.registerObserver(StockItemForm.this);
        }
    }
    
    private void confirmCloseAction() {
        addWindowListener(new WindowAdapter() {
            String newline = System.lineSeparator();
            @Override
            public void windowClosing(WindowEvent e) {
                final List<String> tempStockArray = new ArrayList<>();
                int option = JOptionPane.showConfirmDialog(null, "Do you want to close this window?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION) {
                    for (ASCStockInterface stock : allStockItems) {
                        sBuilder.append(stock.getProductCode());
                        sBuilder.append(",");
                        sBuilder.append(stock.getProductTitle());
                        sBuilder.append(",");
                        sBuilder.append(stock.getProductDesc());
                        sBuilder.append(",");
                        sBuilder.append(stock.getProductPriceInPounds());
                        sBuilder.append(",");
                        sBuilder.append(stock.getProductPriceInPence());
                        sBuilder.append(",");
                        sBuilder.append(stock.getQtyInStock());
                        sBuilder.append(newline);
                    }
                    writeToFile(output,stockItemFile, sBuilder.toString(), false);
                    System.out.println("I HAVE CLOSED OOOOO");
                }
            }
        });
    }
    
    private static void adapteMsmStockItems() {
        for (MSMStockItem stock : allMeganStockItem) {
          MeganAdapter adaptedItem = new MeganAdapter(stock);
            allMeganAdaptedStockItem.add(adaptedItem);
        }
        allStockItems.addAll(allMeganAdaptedStockItem);

        allStockItems.addAll(allASCStockItem);
    }
    
    public static void writeToFile(PrintWriter _output, File _stockItemFile, String _stockItems, boolean isOverrideTrue) {
        try {
            FileWriter fw = new FileWriter(_stockItemFile, isOverrideTrue);
            _output = new PrintWriter(fw);
            _output.print(_stockItems);
            _output.close();

        } catch (FileNotFoundException e) // problem with file !
        {
            System.out.println("Error - problem creating the file! Program closing");
            System.exit(0);  // this terminates the program - parameter 0 indicates normal termination
        } catch (IOException ex) {
            System.out.println("Error - problem creating the file! Program closing");
            System.exit(0);  // this terminates the program - parameter 0 indicates normal termination
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockItemTable = new javax.swing.JTable();
        deleteStockBtn = new javax.swing.JButton();
        createNewStockItem = new javax.swing.JButton();
        addStock = new javax.swing.JButton();
        sellStock = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        transactionHistoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stockItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(stockItemTable);

        deleteStockBtn.setText("Delete Stock");
        deleteStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStockBtnActionPerformed(evt);
            }
        });

        createNewStockItem.setText("Add new Stock");
        createNewStockItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewStockItemActionPerformed(evt);
            }
        });

        addStock.setText("Update Stock Quantity");
        addStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockActionPerformed(evt);
            }
        });

        sellStock.setText("Sell Stock");
        sellStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(deleteStockBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createNewStockItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sellStock)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 333, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteStockBtn)
                    .addComponent(createNewStockItem)
                    .addComponent(addStock)
                    .addComponent(sellStock)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Available Stocks", jPanel1);

        transactionHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(transactionHistoryTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tansaction History", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockActionPerformed
        int isSelectedRow = stockItemTable.getSelectedRow();     // TODO add your handling code here:
        if(isSelectedRow != -1) {
            JTextField stockValue = new JTextField();
            JPanel buyStockFormJPanel = new JPanel(new GridLayout(2, 2));
            buyStockFormJPanel.add(new JLabel("Enter quantity to Add"));
            buyStockFormJPanel.add(stockValue);
            int selectedOption = JOptionPane.showConfirmDialog(null, buyStockFormJPanel, "Buy/Add More Stock Item", JOptionPane.OK_CANCEL_OPTION );
            if(selectedOption == JOptionPane.OK_OPTION && (stockValue.getText().length() > 0)) {
                String _stockValue = stockValue.getText();
                int inputedStockValue = Integer.parseInt(_stockValue);
                ASCStockInterface selectedStock = allStockItems.get(isSelectedRow);
                int inStock = selectedStock.getQtyInStock();
                int newStockQuantity = inStock + inputedStockValue;
                selectedStock.setQuanity(newStockQuantity);
                stockItemTable.updateUI();
            }else {
                JOptionPane.showMessageDialog(null, "Kindly Enter a value", "Note", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No Stock Selected", "Note", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addStockActionPerformed

    private void sellStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellStockActionPerformed
        String newline = System.lineSeparator();
        int isSelectedRow = stockItemTable.getSelectedRow();     // TODO add your handling code here:
        if(isSelectedRow != -1) {
            JTextField stockValue = new JTextField();
            JPanel sellStockFormJPanel = new JPanel(new GridLayout(2, 2));
            sellStockFormJPanel.add(new JLabel("Enter quantity to sell"));
            sellStockFormJPanel.add(stockValue);
            int selectedOption = JOptionPane.showConfirmDialog(null, sellStockFormJPanel, "Sell Stock Item", JOptionPane.OK_CANCEL_OPTION );
            if(selectedOption == JOptionPane.OK_OPTION && (stockValue.getText().length() > 0)) {
                String _stockValue = stockValue.getText();
                int inputedStockValue = Integer.parseInt(_stockValue);
                ASCStockInterface selectedStock = allStockItems.get(isSelectedRow);
                int inStock = selectedStock.getQtyInStock();
                int newStockQuantity = inStock - inputedStockValue;
                selectedStock.setQuanity(newStockQuantity);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
                Date date = new Date();  
                stockItemTable.updateUI();
                inStock = selectedStock.getQtyInStock();
//                if(inStock <= 5) {
//                    String productCode = selectedStock.getProductCode();
//                    JOptionPane.showMessageDialog(null, productCode+" quantity left: " + inStock, "Low Stock Alert", JOptionPane.WARNING_MESSAGE);
//                }
                    
                String stockItemSold = formatter.format(date) +","+ selectedStock.getProductCode() + "," + inputedStockValue +"," +selectedStock.getHumanFriendlyUnitPrice() + newline;
                writeToFile(output,stockItemSoldFile, stockItemSold, true);
            }else {
                JOptionPane.showMessageDialog(null, "Kindly Enter a value", "Note", JOptionPane.WARNING_MESSAGE);
            }
        }else {
            JOptionPane.showMessageDialog(null, "No Stock Selected", "Note", JOptionPane.WARNING_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_sellStockActionPerformed

    private void createNewStockItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewStockItemActionPerformed
                // TODO add your handling code here:
        constructNewStockForm();
        stockItemTable.updateUI();
    }//GEN-LAST:event_createNewStockItemActionPerformed

    private void deleteStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStockBtnActionPerformed
        int isSelectedRow = stockItemTable.getSelectedRow();     // TODO add your handling code here:
        if(isSelectedRow != -1) {
            int selectedOption = JOptionPane.showConfirmDialog(null, "Delete the selected item?", "confirm Delete", 0, 3);
            if(selectedOption == JOptionPane.OK_OPTION) {
                allStockItems.remove(isSelectedRow);
                stockItemTable.updateUI();
            }else {
                JOptionPane.showMessageDialog(null, "Kindly Enter a value", "Note", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No Stock Selected", "Note", JOptionPane.WARNING_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteStockBtnActionPerformed

    private void constructNewStockForm() {
        JRadioButton runningDept = new JRadioButton();
        JRadioButton swimmingDept = new JRadioButton();
        JRadioButton cyclingDept = new JRadioButton();
        ButtonGroup departmentGroup = new ButtonGroup();
        JLabel dpeptLabel = new JLabel("Department: ");
        runningDept.setText("Running");
        runningDept.setBounds(20, 30, 150, 50);
        swimmingDept.setText("Swimming");
        swimmingDept.setBounds(20, 30, 150, 50);
        cyclingDept.setText("Cycling");
        cyclingDept.setBounds(20, 30, 150, 50);
        dpeptLabel.setBounds(20, 30, 150, 50);
        JTextField title = new JTextField();
        JTextField description = new JTextField();
        JTextField price_in_pounds = new JTextField();
        JTextField price_in_pence = new JTextField();
        JTextField quantity = new JTextField();
        JPanel newStockFormJPanel = new JPanel(new GridLayout(8, 2));
        newStockFormJPanel.add(dpeptLabel);
        departmentGroup.add(runningDept);
        departmentGroup.add(swimmingDept);
        departmentGroup.add(cyclingDept);
        newStockFormJPanel.add(cyclingDept);
        newStockFormJPanel.add(runningDept);
        newStockFormJPanel.add(swimmingDept);
        newStockFormJPanel.add(new JLabel("Title"));
        newStockFormJPanel.add(title);
        newStockFormJPanel.add(new JLabel("Description"));
        newStockFormJPanel.add(description);
        newStockFormJPanel.add(new JLabel("Price (£)"));
        newStockFormJPanel.add(price_in_pounds);
        newStockFormJPanel.add(new JLabel("Price (p)"));
        newStockFormJPanel.add(price_in_pence);
        newStockFormJPanel.add(new JLabel("Quantity"));
        newStockFormJPanel.add(quantity);
        

        int selectedOption = JOptionPane.showConfirmDialog(null, newStockFormJPanel, "New Stock Item Form", JOptionPane.OK_CANCEL_OPTION );
        if(selectedOption == JOptionPane.OK_OPTION && (cyclingDept.isSelected() || runningDept.isSelected() || swimmingDept.isSelected())) {
           String _title = title.getText();
           String _description = description.getText();
           String _price_in_pounds = price_in_pounds.getText();
           String _price_in_pence = price_in_pence.getText();
           String _quantity = quantity.getText();
           int department = 0;
           if(runningDept.isSelected()) {
               department = 1;
           }
           if(swimmingDept.isSelected()) {
               department = 2;
           }

           if(cyclingDept.isSelected()) {
               department = 3;
           }
        
           ASCStockItem newStockItem  = new ASCStockItem(department, _title, _description, Integer.parseInt(_price_in_pounds), Integer.parseInt(_price_in_pence), Integer.parseInt(_quantity));
           allStockItems.add(newStockItem);

       }else {
           JOptionPane.showMessageDialog(null, "No Department Selected", "Note", JOptionPane.WARNING_MESSAGE);
       }
        // return selectedOption;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockItemForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStock;
    private javax.swing.JButton createNewStockItem;
    private javax.swing.JButton deleteStockBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton sellStock;
    private javax.swing.JTable stockItemTable;
    private javax.swing.JTable transactionHistoryTable;
    // End of variables declaration//GEN-END:variables


    @Override
    public void notifyObserver(ASCStockInterface stock) {
        JOptionPane.showMessageDialog(null, stock.getProductCode()+" quantity left: " + stock.getQtyInStock(), "Low Stock Alert", JOptionPane.WARNING_MESSAGE);
    }
}
