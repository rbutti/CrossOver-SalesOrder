package com.dev.frontend.panels.edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.dev.frontend.services.Services;

public class EditCustomer extends EditContentPanel
{
    private static final long serialVersionUID = -8971249970444644844L;
    static final Logger logger = Logger.getLogger(EditCustomer.class);

    private final JTextField txtCode = new JTextField();
    private final JTextField txtName = new JTextField();
    private final JTextField txtAddress = new JTextField();
    private final JTextField txtPhone1 = new JTextField();
    private final JTextField txtPhone2 = new JTextField();
    private final JTextField txtCreditLimit = new JTextField();
    private final JTextField txtCurrentCredit = new JTextField();

    private JSONObject customer = new JSONObject();

    public EditCustomer()
    {
	GridBagLayout gridBagLayout = new GridBagLayout();
	setLayout(gridBagLayout);

	GridBagConstraints gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 0;
	gbc.gridy = 0;
	add(new JLabel("Code"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.fill = GridBagConstraints.HORIZONTAL;
	add(txtCode, gbc);
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	txtCode.setColumns(10);
	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 0;
	gbc.gridy = 1;
	add(new JLabel("Name"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 1;
	gbc.gridwidth = 3;
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	add(txtName, gbc);
	txtName.setColumns(28);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 0;
	gbc.gridy = 2;
	add(new JLabel("Address"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 2;
	gbc.gridwidth = 3;
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	add(txtAddress, gbc);
	txtAddress.setColumns(28);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 0;
	gbc.gridy = 3;
	add(new JLabel("Phone 1"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 3;
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	add(txtPhone1, gbc);
	txtPhone1.setColumns(10);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 2;
	gbc.gridy = 3;
	add(new JLabel("Phone 2"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 15);
	gbc.gridx = 3;
	gbc.gridy = 3;
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	add(txtPhone2, gbc);
	txtPhone2.setColumns(10);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 0;
	gbc.gridy = 4;
	add(new JLabel("Credit Limit"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 1;
	gbc.gridy = 4;
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	add(txtCreditLimit, gbc);
	txtCreditLimit.setColumns(10);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 5);
	gbc.gridx = 2;
	gbc.gridy = 4;
	add(new JLabel("Current Credit"), gbc);

	gbc = new GridBagConstraints();
	gbc.insets = new Insets(5, 5, 5, 15);
	gbc.gridx = 3;
	gbc.gridy = 4;
	gbc.anchor = GridBagConstraints.LAST_LINE_START;
	add(txtCurrentCredit, gbc);
	txtCurrentCredit.setColumns(10);
	txtCurrentCredit.setEditable(false);

    }

    @Override
    public boolean bindToGUI(Object o)
    {
	logger.debug("bindToGUI() | Customer Object: " + o.toString());
	customer = (JSONObject) o;
	txtCode.setText(customer.get("code").toString());
	txtName.setText(customer.get("name").toString());
	txtAddress.setText(customer.get("address").toString());
	txtPhone1.setText(customer.get("phone1").toString());
	txtPhone2.setText(customer.get("phone2").toString());
	txtCreditLimit.setText(customer.get("creditLimit").toString());
	txtCurrentCredit.setText(customer.get("currentCredit").toString());

	return false;
    }

    @Override
    public Object guiToObject()
    {
	logger.debug("guiToObject() | Customer Object: " + customer);
	customer.put("code", txtCode.getText());
	customer.put("name", txtName.getText());
	customer.put("address", txtAddress.getText());
	customer.put("phone1", txtPhone1.getText());
	customer.put("phone2", txtPhone2.getText());
	customer.put("creditLimit", txtCreditLimit.getText());
	if (txtCurrentCredit.getText().length() > 0) {
	    customer.put("currentCredit", txtCurrentCredit.getText());
	}
	else {
	    customer.put("currentCredit", "0");
	}

	return customer;
    }

    @Override
    public int getObjectType()
    {
	return Services.TYPE_CUSTOMER;
    }

    @Override
    public String getCurrentCode()
    {
	return txtCode.getText();
    }

    @Override
    public void clear()
    {
	txtCode.setText("");
	txtName.setText("");
	txtAddress.setText("");
	txtPhone1.setText("");
	txtPhone2.setText("");
	txtCreditLimit.setText("");
	txtCurrentCredit.setText("");
	customer.clear();
    }

    @Override
    public void onInit()
    {

    }
}
