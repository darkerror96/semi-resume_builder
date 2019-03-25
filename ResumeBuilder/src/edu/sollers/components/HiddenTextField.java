package edu.sollers.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 * @author rutpatel
 */

public class HiddenTextField extends JTextField {
	private static final long serialVersionUID = 1;
	Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
	Font lostFont = new Font("Tahoma", Font.ITALIC, 11);

	public HiddenTextField(final String hint) {
		setText(hint);
		setFont(lostFont);
		setForeground(Color.GRAY);

		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint)) {
					setText("");
					setFont(gainFont);
				} else {
					setText(getText());
					setFont(gainFont);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals(hint) || getText().length() == 0) {
					setText(hint);
					setFont(lostFont);
					setForeground(Color.GRAY);
				} else {
					setText(getText());
					setFont(gainFont);
					setForeground(Color.BLACK);
				}
			}
		});
	}
}
