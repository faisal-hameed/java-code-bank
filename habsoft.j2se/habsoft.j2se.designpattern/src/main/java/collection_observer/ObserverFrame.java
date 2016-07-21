package collection_observer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ObserverFrame implements ICollectionObserver {
	JFrame frame;
	ObservableList list;
	JTextField txtValue;
	JButton btnAdd;
	JButton btnRemove;

	public ObserverFrame() {
		list = new ObservableList();
		list.addCollectionObserver(this);
		frame = new JFrame("Observer Patteren");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(txtValue = new JTextField());
		txtValue.setText("List size " + list.size());

		frame.add(btnAdd = new JButton("Add"));

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.add(new Integer(list.size() + 1));
				// txtValue.setText(String.valueOf(value.getValue()));
			}
		});

		frame.add(btnRemove = new JButton("Remove"));

		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				list.remove(new Integer(list.size() - 1));
				// txtValue.setText(String.valueOf(value.getValue()));
			}
		});

		frame.setBounds(200, 300, 400, 200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ObserverFrame();
	}

	@Override
	public void itemAdded(Object o) {
		System.out.println("item added");
		txtValue.setText("List Size " + list.size());

	}

	@Override
	public void itemRemoved(Object o) {
		System.out.println("item removed");
		txtValue.setText("List Size " + list.size());
	}

}
