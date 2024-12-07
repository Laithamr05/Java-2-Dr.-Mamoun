package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ShapeHandler implements EventHandler<ActionEvent> {
	Main a;
	Rec b;

	public ShapeHandler(Main a) {
		this.a = a;
	}

	public ShapeHandler(Rec b) {
		this.b = b;
	}

	@Override
	public void handle(ActionEvent event) {
		if (a instanceof Main) {

			if (event.getSource() == a.b) {
				a.circle.setRadius(a.circle.getRadius() + 5);
			}
			if (event.getSource() == a.m) {
				a.circle.setRadius(a.circle.getRadius() - 5);
			}
		} else if (b instanceof Rec) {

			if (event.getSource() == b.b) {
				b.circle.setHeight(b.circle.getHeight() + 5);
				b.circle.setWidth(b.circle.getWidth() + 5);
			}
			if (event.getSource() == b.m) {
				b.circle.setHeight(b.circle.getHeight() - 5);
				b.circle.setWidth(b.circle.getWidth() - 5);
			}
		}
	}
}
