package com.interfaces;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;


class MyComboBoxEditor extends DefaultCellEditor {
  public MyComboBoxEditor(String[] items) {
    super(new JComboBox(items));
  }
}