package com.diboxku.client.model;


import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;

public class PageOverview extends LayoutContainer {



	private ContentPanel cp;
	private ContentPanel center;

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);
		setLayout(new FitLayout());

		cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setFrame(false);
		cp.setBorders(false);
		cp.setLayout(new RowLayout(Orientation.HORIZONTAL));
		center = centerPanel();

		ContentPanel contentPanel = new ContentPanel();
		contentPanel.setHeaderVisible(false);
		contentPanel.setLayout(new RowLayout(Orientation.HORIZONTAL));
		contentPanel.add(center, new RowData(1, 1));
		cp.add(contentPanel, new RowData(1, 1));
	}

	private ContentPanel centerPanel() {
		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setLayout(new RowLayout(Orientation.HORIZONTAL));

		cp.setBodyBorder(false);

		return cp;
	}
}
