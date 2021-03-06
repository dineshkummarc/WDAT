package org.gnode.wda.explorer;

import org.gnode.wda.data.NeoObject;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class TopLevelSelectorWidget extends Composite {
	HorizontalPanel main;
	ListBox lb;

	public TopLevelSelectorWidget() {
		this.main = new HorizontalPanel();
		this.lb = new ListBox(false);
	
		this.lb.addItem("Select", "null");
		for (String item: NeoObject.getContainers()) {
			lb.addItem(item);
		}
		
		initWidget(main);
		
		main.add(new Label("Browse by :"));
		main.add(this.lb);
	}
	
	public String getSelection() {
		String rtn = this.lb.getItemText(this.lb.getSelectedIndex());
		return rtn;
	}
	
	public void setChangeHandler(ChangeHandler handler) {
		this.lb.addChangeHandler(handler);
	}
}
