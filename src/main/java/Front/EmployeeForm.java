package Front;

import Models.Employee.Employee;
import Models.Employee.EmployeeService;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeForm implements ActionListener{
    private EmployeeService employeeService;
    private List<Employee> data1;
    private JPanel panel1;
    private JList list;
    private JButton AddButton;
    private JButton RedactButton;
    private JButton DelButton;
    private JButton ExitButton;

    private JFrame frame;

    public EmployeeForm(EmployeeService employeeService) throws SQLException {
        this.employeeService = employeeService;
        this.data1 = new ArrayList<>(employeeService.getAllEmployees());
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        frame=new JFrame("Employee");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        try {
            list.setListData(employeeService.getAllEmployees().toArray());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
