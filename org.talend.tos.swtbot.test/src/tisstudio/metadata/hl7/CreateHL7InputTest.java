// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package tisstudio.metadata.hl7;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.matchers.WidgetOfType;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.swtbot.TalendSwtBotForTos;
import org.talend.swtbot.Utilities;

/**
 * DOC Administrator class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class CreateHL7InputTest extends TalendSwtBotForTos {

    private SWTBotView view;

    private SWTBotTree tree;

    private SWTBotTreeItem treeNode;

    private static final String HL7NAME = "hl7_1"; //$NON-NLS-1$ 

    private static final String SAMPLE_RELATIVE_FILEPATH = "HL7.txt"; //$NON-NLS-1$

    private static final String[] COLUMN_MSH = { "MSH-1(1)-1-1[ST]", "MSH-2(1)-1-1[ST]", "MSH-3(1)-1-1[IS]" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    private static final String[] COLUMN_EVN = { "EVN-1(1)-1-1[ID]", "EVN-2(1)-1-1[TSComponentOne]" }; //$NON-NLS-1$ //$NON-NLS-2$

    @Before
    public void initialisePrivateFields() {
        view = Utilities.getRepositoryView(gefBot);
        view.setFocus();
        tree = new SWTBotTree((Tree) gefBot.widget(WidgetOfType.widgetOfType(Tree.class), view.getWidget()));
        treeNode = Utilities.getTalendItemNode(tree, Utilities.TalendItemType.HL7);
    }

    @Test
    public void createHL7Input() throws IOException, URISyntaxException {
        tree.setFocus();
        try {
            tree.expandNode("Metadata").getNode("HL7").contextMenu("Create HL7").click();
            gefBot.waitUntil(Conditions.shellIsActive("New HL7 File"));
            gefBot.shell("New HL7 File").activate();

            /* step 1 of 5 */
            gefBot.textWithLabel("Name").setText(HL7NAME);
            gefBot.button("Next >").click();

            /* step 2 of 5 */
            gefBot.button("Next >").click();

            /* step 3 of 5 */
            gefBot.textWithLabel("HL7 File path:").setText(
                    Utilities.getFileFromCurrentPluginSampleFolder(SAMPLE_RELATIVE_FILEPATH).getAbsolutePath());
            gefBot.button("Next >").click();

            /* step 4 of 5 */
            for (int i = 0; i < 3; i++) {
                gefBot.buttonWithTooltip("Add").click();
                gefBot.tableInGroup("Schema View").click(i, 3);
                gefBot.text().setText(COLUMN_MSH[i]);
            }
            gefBot.comboBoxWithLabel("Segment(As Schema)").setSelection("EVN");
            for (int j = 0; j < 2; j++) {
                gefBot.buttonWithTooltip("Add").click();
                gefBot.tableInGroup("Schema View").click(j, 3);
                gefBot.text().setText(COLUMN_EVN[j]);
            }
            gefBot.button("Next >").click();

            /* step 5 of 5 */
            gefBot.button("Finish").click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            gefBot.shell("New HL7 File").close();
        }

        SWTBotTreeItem newHl7Item = null;
        try {
            newHl7Item = tree.expandNode("Metadata", "HL7").select(HL7NAME + " 0.1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotNull("hl7 item is not created", newHl7Item);
        }
    }

    @After
    public void removePreviouslyCreateItems() throws IOException, URISyntaxException {
        if (Utilities.getFileFromCurrentPluginSampleFolder("cobocurs.xc2j").exists())
            Utilities.getFileFromCurrentPluginSampleFolder("cobocurs.xc2j").delete();
        Utilities.delete(tree, treeNode, HL7NAME, "0.1", null);
        Utilities.emptyRecycleBin(gefBot, tree);
    }
}
