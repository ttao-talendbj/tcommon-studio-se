// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.updates.runtime.ui.feature.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.talend.updates.runtime.ui.feature.form.listener.ICheckListener;
import org.talend.updates.runtime.ui.feature.model.runtime.FeaturesManagerRuntimeData;


/**
 * DOC cmeng  class global comment. Detailled comment
 */
public abstract class AbstractFeatureForm extends Composite {

    private FeaturesManagerRuntimeData runtimeData;

    public AbstractFeatureForm(Composite parent, int style, FeaturesManagerRuntimeData runtimeData) {
        super(parent, style);
        this.runtimeData = runtimeData;
        init();
    }

    protected void init() {
        FormLayout panelLayout = new FormLayout();
        this.setLayout(panelLayout);
        this.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
        initControl(this);
        initLayout();
        initData();
        addListeners();
    }

    protected void initControl(Composite parent) {
        // nothing to do
    }

    protected void initLayout() {
        // nothing to do
    }

    protected void initData() {
        // nothing to do
    }

    protected void addListeners() {
        // nothing to do
    }

    public ICheckListener getCheckListener() {
        return getRuntimeData().getCheckListener();
    }

    protected FeaturesManagerRuntimeData getRuntimeData() {
        return this.runtimeData;
    }

    protected int getHorizonAlignWidth() {
        return 5;
    }

    protected int getVersionAlignWidth() {
        return 5;
    }

    protected int getComboWidth() {
        return 100;
    }

}
