package observer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ObserverFrame implements Observer {
	JFrame frame;
	ObserveableValue value;
	JTextField txtValue;
	JButton btnOk;

	public ObserverFrame() {
		value = new ObserveableValue(10);
		value.addObserver(this);
		frame = new JFrame("Observer Patteren");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(txtValue = new JTextField());
		txtValue.setText(String.valueOf(value.getValue()));

		frame.add(btnOk = new JButton("OK"));

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				value.setValue(value.getValue() + 1);
				// txtValue.setText(String.valueOf(value.getValue()));
			}
		});

		frame.setBounds(200, 300, 200, 200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ObserverFrame();
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(o);
		if (o instanceof ObserveableValue) {
			txtValue.setText(String.valueOf(((ObserveableValue) o).getValue()));
		}
	}
}
