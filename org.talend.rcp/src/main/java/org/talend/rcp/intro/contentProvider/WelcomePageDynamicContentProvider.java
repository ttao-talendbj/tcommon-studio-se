// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.rcp.intro.contentProvider;

import java.io.PrintWriter;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.intro.config.IIntroContentProviderSite;
import org.eclipse.ui.intro.config.IIntroXHTMLContentProvider;
import org.talend.rcp.i18n.Messages;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * DOC hcyi class global comment. Detailled comment
 */
public class WelcomePageDynamicContentProvider implements IIntroXHTMLContentProvider {

    private static final String BROWSER_URL = "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.rcp&class=org.talend.rcp.intro.OpenWebBrowserAction&type="; //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.intro.config.IIntroXHTMLContentProvider#createContent(java.lang.String, org.w3c.dom.Element)
     */
    public void createContent(String id, Element parent) {
        Document dom = parent.getOwnerDocument();
        String content = dom.getBaseURI();
        if (content != null && !"".equals(content)) {
            content = content.substring(0, content.length() - 10);
        }
        if ("ITEMSJOB".equals(id)) {
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_1 style_2 style_3");
            span.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.LatestItems.Title")));
            parent.appendChild(span);
            parent.appendChild(dom.createElement("br"));
            Element img = dom.createElement("img");
            img.setAttribute("style", "padding-top:10px;margin-left:15px;");
            img.setAttribute("src", content + "imgs/img_process.jpg");
            Element span2 = dom.createElement("span");
            span2.setAttribute("class", "style_3");
            span2.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.LatestItemsJob.Title")));
            parent.appendChild(img);
            parent.appendChild(span2);
        } else if ("ITEMSBUSINESSMODEL".equals(id)) {
            Element img = dom.createElement("img");
            img.setAttribute("style", "padding-top:15px;margin-left:15px;");
            img.setAttribute("src", content + "imgs/img_businessProcess.jpg");
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_3");
            span.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.LatestItemsBusinessModel.Title")));
            parent.appendChild(img);
            parent.appendChild(span);

        } else if ("ITEMSANALYSIS".equals(id)) {
            Element img = dom.createElement("img");
            img.setAttribute("style", "padding-top:10px;margin-left:15px;");
            img.setAttribute("src", content + "imgs/chart_bar.png");
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_3");
            span.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.LatestItemsAnalysis.Title")));
            parent.appendChild(img);
            parent.appendChild(span);
        } else if ("ITEMSSERVICESPORT".equals(id)) {
            Element img = dom.createElement("img");
            img.setAttribute("style", "padding-top:10px;margin-left:15px;");
            img.setAttribute("src", content + "imgs/img_service.png");
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_3");
            span.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.LatestItemsServices.Title")));
            parent.appendChild(img);
            parent.appendChild(span);
        } else if ("ITEMSROUTE".equals(id)) {
            Element img = dom.createElement("img");
            img.setAttribute("style", "padding-top:15px;margin-left:15px;");
            img.setAttribute("src", content + "imgs/img_route.png");
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_3");
            span.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.LatestItemsRoutes.Title")));
            parent.appendChild(img);
            parent.appendChild(span);
        } else if ("CREATENEWTITLE".equals(id)) {
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_1 style_2 style_3");
            span.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.CreateNewTitle")));
            parent.appendChild(span);
            parent.appendChild(dom.createElement("br"));
            Element imgJob = dom.createElement("img");
            imgJob.setAttribute("style", "padding-top:10px;margin-left:15px;");
            imgJob.setAttribute("src", content + "imgs/img_process.jpg");
            parent.appendChild(imgJob);
            Element hyperlinkJob = dom.createElement("a");
            hyperlinkJob.setAttribute("class", "xh");
            hyperlinkJob.setAttribute("title", "Create a data integration process");
            hyperlinkJob
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.core&class=org.talend.designer.core.ui.action.CreateProcess&id=org.talend.designer.core.actions.createprocess&type=PROCESS");
            Element span2 = dom.createElement("span");
            span2.setAttribute("class", "style_3");
            span2.appendChild(dom.createTextNode(" " + Messages.getString("WelcomePageDynamicContentProvider.CreateNewJobTitle")));
            hyperlinkJob.appendChild(span2);
            parent.appendChild(hyperlinkJob);
            //
            parent.appendChild(dom.createElement("br"));
            Element imgBusiness = dom.createElement("img");
            imgBusiness.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgBusiness.setAttribute("src", content + "imgs/img_businessProcess.jpg");
            parent.appendChild(imgBusiness);
            Element hyperlinkBusiness = dom.createElement("a");
            hyperlinkBusiness.setAttribute("class", "xh");
            hyperlinkBusiness.setAttribute("title", "Create a business model");
            hyperlinkBusiness
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.business.diagram&class=org.talend.designer.business.diagram.custom.actions.CreateDiagramAction&id=org.talend.designer.business.diagram.Action1&type=BUSINESS_PROCESS");
            Element spanBusiness = dom.createElement("span");
            spanBusiness.setAttribute("class", "style_3");
            spanBusiness.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewBusinessModelTitle")));
            hyperlinkBusiness.appendChild(spanBusiness);
            parent.appendChild(hyperlinkBusiness);

        } else if ("CREATENEWWITHDQTITLE".equals(id)) {
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_1 style_2 style_3");
            span.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.CreateNewTitle")));
            parent.appendChild(span);
            parent.appendChild(dom.createElement("br"));
            Element imgJob = dom.createElement("img");
            imgJob.setAttribute("style", "padding-top:10px;margin-left:15px;");
            imgJob.setAttribute("src", content + "imgs/img_process.jpg");
            parent.appendChild(imgJob);
            Element hyperlinkJob = dom.createElement("a");
            hyperlinkJob.setAttribute("class", "xh");
            hyperlinkJob.setAttribute("title", "Create a data integration process");
            hyperlinkJob
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.core&class=org.talend.designer.core.ui.action.CreateProcess&id=org.talend.designer.core.actions.createprocess&type=PROCESS");
            Element span2 = dom.createElement("span");
            span2.setAttribute("class", "style_3");
            span2.appendChild(dom.createTextNode(" " + Messages.getString("WelcomePageDynamicContentProvider.CreateNewJobTitle")));
            hyperlinkJob.appendChild(span2);
            parent.appendChild(hyperlinkJob);
            //
            parent.appendChild(dom.createElement("br"));
            Element imgBusiness = dom.createElement("img");
            imgBusiness.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgBusiness.setAttribute("src", content + "imgs/img_businessProcess.jpg");
            parent.appendChild(imgBusiness);
            Element hyperlinkBusiness = dom.createElement("a");
            hyperlinkBusiness.setAttribute("class", "xh");
            hyperlinkBusiness.setAttribute("title", "Create a business model");
            hyperlinkBusiness
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.business.diagram&class=org.talend.designer.business.diagram.custom.actions.CreateDiagramAction&id=org.talend.designer.business.diagram.Action1&type=BUSINESS_PROCESS");
            Element spanBusiness = dom.createElement("span");
            spanBusiness.setAttribute("class", "style_3");
            spanBusiness.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewBusinessModelTitle")));
            hyperlinkBusiness.appendChild(spanBusiness);
            parent.appendChild(hyperlinkBusiness);

            //
            parent.appendChild(dom.createElement("br"));
            Element imgBarChart = dom.createElement("img");
            imgBarChart.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgBarChart.setAttribute("src", content + "imgs/chart_bar.png");
            parent.appendChild(imgBarChart);
            Element hyperlinkBarChart = dom.createElement("a");
            hyperlinkBarChart.setAttribute("class", "xh");
            hyperlinkBarChart.setAttribute("title", "Create an analysis");
            hyperlinkBarChart
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.dataprofiler.core&class=org.talend.dataprofiler.core.ui.action.actions.CreateNewAnalysisAction&id=org.talend.dataprofiler.core.ui.action.actions.CreateNewAnalysisAction&type=ANALYSIS");
            Element spanBarChart = dom.createElement("span");
            spanBarChart.setAttribute("class", "style_3");
            spanBarChart.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewAnalysisTitle")));
            hyperlinkBarChart.appendChild(spanBarChart);
            parent.appendChild(hyperlinkBarChart);

        } else if ("CREATENEWWITHESBTITLE".equals(id)) {
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_1 style_2 style_3");
            span.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.CreateNewTitle")));
            parent.appendChild(span);
            parent.appendChild(dom.createElement("br"));
            Element imgJob = dom.createElement("img");
            imgJob.setAttribute("style", "padding-top:10px;margin-left:15px;");
            imgJob.setAttribute("src", content + "imgs/img_process.jpg");
            parent.appendChild(imgJob);
            Element hyperlinkJob = dom.createElement("a");
            hyperlinkJob.setAttribute("class", "xh");
            hyperlinkJob.setAttribute("title", "Create a data integration process");
            hyperlinkJob
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.core&class=org.talend.designer.core.ui.action.CreateProcess&id=org.talend.designer.core.actions.createprocess&type=PROCESS");
            Element span2 = dom.createElement("span");
            span2.setAttribute("class", "style_3");
            span2.appendChild(dom.createTextNode(" " + Messages.getString("WelcomePageDynamicContentProvider.CreateNewJobTitle")));
            hyperlinkJob.appendChild(span2);
            parent.appendChild(hyperlinkJob);
            //
            parent.appendChild(dom.createElement("br"));
            Element imgBusiness = dom.createElement("img");
            imgBusiness.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgBusiness.setAttribute("src", content + "imgs/img_businessProcess.jpg");
            parent.appendChild(imgBusiness);
            Element hyperlinkBusiness = dom.createElement("a");
            hyperlinkBusiness.setAttribute("class", "xh");
            hyperlinkBusiness.setAttribute("title", "Create a business model");
            hyperlinkBusiness
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.business.diagram&class=org.talend.designer.business.diagram.custom.actions.CreateDiagramAction&id=org.talend.designer.business.diagram.Action1&type=BUSINESS_PROCESS");
            Element spanBusiness = dom.createElement("span");
            spanBusiness.setAttribute("class", "style_3");
            spanBusiness.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewBusinessModelTitle")));
            hyperlinkBusiness.appendChild(spanBusiness);
            parent.appendChild(hyperlinkBusiness);

            //
            parent.appendChild(dom.createElement("br"));
            Element imgService = dom.createElement("img");
            imgService.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgService.setAttribute("src", content + "imgs/img_service.png");
            parent.appendChild(imgService);
            Element hyperlinkService = dom.createElement("a");
            hyperlinkService.setAttribute("class", "xh");
            hyperlinkService.setAttribute("title", "Create a service");
            hyperlinkService
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.repository.services&class=org.talend.repository.services.action.CreateESBAction&id=org.talend.repository.services.action.CreateESBAction&type=SERVICES");
            Element spanService = dom.createElement("span");
            spanService.setAttribute("class", "style_3");
            spanService.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewServiceTitle")));
            hyperlinkService.appendChild(spanService);
            parent.appendChild(hyperlinkService);

            //
            parent.appendChild(dom.createElement("br"));
            Element imgRoute = dom.createElement("img");
            imgRoute.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgRoute.setAttribute("src", content + "imgs/img_route.png");
            parent.appendChild(imgRoute);
            Element hyperlinkRoute = dom.createElement("a");
            hyperlinkRoute.setAttribute("class", "xh");
            hyperlinkRoute.setAttribute("title", "Create a service");
            hyperlinkRoute
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.camel.designer&class=org.talend.camel.designer.ui.CreateCamelProcess&id=org.talend.camel.designer.ui.CreateCamelProcess&type=ROUTES");
            Element spanRoute = dom.createElement("span");
            spanRoute.setAttribute("class", "style_3");
            spanRoute.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewRouteTitle")));
            hyperlinkRoute.appendChild(spanRoute);
            parent.appendChild(hyperlinkRoute);

        } else if ("CREATENEWWITHDQESBTITLE".equals(id)) {
            Element span = dom.createElement("span");
            span.setAttribute("class", "style_1 style_2 style_3");
            span.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.CreateNewTitle")));
            parent.appendChild(span);
            parent.appendChild(dom.createElement("br"));
            Element imgJob = dom.createElement("img");
            imgJob.setAttribute("style", "padding-top:10px;margin-left:15px;");
            imgJob.setAttribute("src", content + "imgs/img_process.jpg");
            parent.appendChild(imgJob);
            Element hyperlinkJob = dom.createElement("a");
            hyperlinkJob.setAttribute("class", "xh");
            hyperlinkJob.setAttribute("title", "Create a data integration process");
            hyperlinkJob
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.core&class=org.talend.designer.core.ui.action.CreateProcess&id=org.talend.designer.core.actions.createprocess&type=PROCESS");
            Element span2 = dom.createElement("span");
            span2.setAttribute("class", "style_3");
            span2.appendChild(dom.createTextNode(" " + Messages.getString("WelcomePageDynamicContentProvider.CreateNewJobTitle")));
            hyperlinkJob.appendChild(span2);
            parent.appendChild(hyperlinkJob);
            //
            parent.appendChild(dom.createElement("br"));
            Element imgBusiness = dom.createElement("img");
            imgBusiness.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgBusiness.setAttribute("src", content + "imgs/img_businessProcess.jpg");
            parent.appendChild(imgBusiness);
            Element hyperlinkBusiness = dom.createElement("a");
            hyperlinkBusiness.setAttribute("class", "xh");
            hyperlinkBusiness.setAttribute("title", "Create a business model");
            hyperlinkBusiness
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.designer.business.diagram&class=org.talend.designer.business.diagram.custom.actions.CreateDiagramAction&id=org.talend.designer.business.diagram.custom.actions.CreateDiagramAction&type=BUSINESS_PROCESS");
            Element spanBusiness = dom.createElement("span");
            spanBusiness.setAttribute("class", "style_3");
            spanBusiness.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewBusinessModelTitle")));
            hyperlinkBusiness.appendChild(spanBusiness);
            parent.appendChild(hyperlinkBusiness);

            //
            parent.appendChild(dom.createElement("br"));
            Element imgBarChart = dom.createElement("img");
            imgBarChart.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgBarChart.setAttribute("src", content + "imgs/chart_bar.png");
            parent.appendChild(imgBarChart);
            Element hyperlinkBarChart = dom.createElement("a");
            hyperlinkBarChart.setAttribute("class", "xh");
            hyperlinkBarChart.setAttribute("title", "Create an analysis");
            hyperlinkBarChart
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.dataprofiler.core&class=org.talend.dataprofiler.core.ui.action.actions.CreateNewAnalysisAction&id=org.talend.dataprofiler.core.ui.action.actions.CreateNewAnalysisAction&type=ANALYSIS");
            Element spanBarChart = dom.createElement("span");
            spanBarChart.setAttribute("class", "style_3");
            spanBarChart.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewAnalysisTitle")));
            hyperlinkBarChart.appendChild(spanBarChart);
            parent.appendChild(hyperlinkBarChart);

            //
            parent.appendChild(dom.createElement("br"));
            Element imgService = dom.createElement("img");
            imgService.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgService.setAttribute("src", content + "imgs/img_service.png");
            parent.appendChild(imgService);
            Element hyperlinkService = dom.createElement("a");
            hyperlinkService.setAttribute("class", "xh");
            hyperlinkService.setAttribute("title", "Create a service");
            hyperlinkService
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.repository.services&class=org.talend.repository.services.action.CreateESBAction&id=org.talend.repository.services.action.CreateESBAction&type=SERVICES");
            Element spanService = dom.createElement("span");
            spanService.setAttribute("class", "style_3");
            spanService.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewServiceTitle")));
            hyperlinkService.appendChild(spanService);
            parent.appendChild(hyperlinkService);

            //
            parent.appendChild(dom.createElement("br"));
            Element imgRoute = dom.createElement("img");
            imgRoute.setAttribute("style", "padding-top:15px;margin-left:15px;");
            imgRoute.setAttribute("src", content + "imgs/img_route.png");
            parent.appendChild(imgRoute);
            Element hyperlinkRoute = dom.createElement("a");
            hyperlinkRoute.setAttribute("class", "xh");
            hyperlinkRoute.setAttribute("title", "Create a service");
            hyperlinkRoute
                    .setAttribute(
                            "href",
                            "http://org.eclipse.ui.intro/runAction?pluginId=org.talend.camel.designer&class=org.talend.camel.designer.ui.CreateCamelProcess&id=org.talend.camel.designer.ui.CreateCamelProcess&type=ROUTES");
            Element spanRoute = dom.createElement("span");
            spanRoute.setAttribute("class", "style_3");
            spanRoute.appendChild(dom.createTextNode(" "
                    + Messages.getString("WelcomePageDynamicContentProvider.CreateNewRouteTitle")));
            hyperlinkRoute.appendChild(spanRoute);
            parent.appendChild(hyperlinkRoute);

        } else if ("DOCUMENTATIONTITLE".equals(id)) {
            Element pDoc = dom.createElement("p");
            pDoc.setAttribute("class", "style_1 style_2 style_3");
            pDoc.setAttribute("style", "padding-top:10px;");
            pDoc.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.DocumentationTitle")));
            parent.appendChild(pDoc);
            Element blockquoteDoc = dom.createElement("blockquote");
            Element blockquotePDoc = dom.createElement("p");
            Element blockquoteA1Doc = dom.createElement("a");
            blockquoteA1Doc.setAttribute("href", BROWSER_URL + "showUserGuide");
            blockquoteA1Doc.appendChild(dom.createTextNode(Messages
                    .getString("WelcomePageDynamicContentProvider.DocumentationUserGuideTitle")));

            Element blockquoteA2Doc = dom.createElement("a");
            blockquoteA2Doc.setAttribute("href", BROWSER_URL + "showReferenceGuide");
            blockquoteA2Doc.appendChild(dom.createTextNode(Messages
                    .getString("WelcomePageDynamicContentProvider.DocumentationReferenceGuideTitle")));
            blockquotePDoc.appendChild(blockquoteA1Doc);
            blockquotePDoc.appendChild(dom.createElement("br"));
            blockquotePDoc.appendChild(blockquoteA2Doc);
            blockquoteDoc.appendChild(blockquotePDoc);
            parent.appendChild(blockquoteDoc);
        } else if ("GETTINGSTARTEDTITLE".equals(id)) {
            Element pGS = dom.createElement("p");
            pGS.setAttribute("class", "style_1 style_2 style_3");
            pGS.setAttribute("style", "padding-top:10px;");
            pGS.appendChild(dom.createTextNode(Messages.getString("WelcomePageDynamicContentProvider.GettingStartedTitle")));
            parent.appendChild(pGS);
            Element blockquoteGS = dom.createElement("blockquote");
            Element blockquotePGS = dom.createElement("p");
            Element blockquoteA1GS = dom.createElement("a");
            blockquoteA1GS.setAttribute("href", BROWSER_URL + "showTutorials");
            blockquoteA1GS.appendChild(dom.createTextNode(Messages
                    .getString("WelcomePageDynamicContentProvider.GettingStartedTutorialsTitle")));

            Element blockquoteA2GS = dom.createElement("a");
            blockquoteA2GS.setAttribute("href", BROWSER_URL + "showForums");
            blockquoteA2GS.appendChild(dom.createTextNode(Messages
                    .getString("WelcomePageDynamicContentProvider.GettingStartedForumsTitle")));

            Element blockquoteA3GS = dom.createElement("a");
            blockquoteA3GS.setAttribute("href", BROWSER_URL + "showExchange");
            blockquoteA3GS.appendChild(dom.createTextNode(Messages
                    .getString("WelcomePageDynamicContentProvider.GettingStartedExchangeTitle")));

            blockquotePGS.appendChild(blockquoteA1GS);
            blockquotePGS.appendChild(dom.createTextNode(": "
                    + Messages.getString("WelcomePageDynamicContentProvider.GettingStartedTutorialsBrief")));
            blockquotePGS.appendChild(dom.createElement("br"));
            blockquotePGS.appendChild(blockquoteA2GS);
            blockquotePGS.appendChild(dom.createTextNode(": "
                    + Messages.getString("WelcomePageDynamicContentProvider.GettingStartedForumsBrief")));
            blockquotePGS.appendChild(dom.createElement("br"));
            blockquotePGS.appendChild(blockquoteA3GS);
            blockquotePGS.appendChild(dom.createTextNode(": "
                    + Messages.getString("WelcomePageDynamicContentProvider.GettingStartedExchangeBrief")));
            blockquoteGS.appendChild(blockquotePGS);
            parent.appendChild(blockquoteGS);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.intro.config.IIntroContentProvider#init(org.eclipse.ui.intro.config.IIntroContentProviderSite)
     */
    public void init(IIntroContentProviderSite site) {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.intro.config.IIntroContentProvider#createContent(java.lang.String, java.io.PrintWriter)
     */
    public void createContent(String id, PrintWriter out) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.intro.config.IIntroContentProvider#createContent(java.lang.String,
     * org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
     */
    public void createContent(String id, Composite parent, FormToolkit toolkit) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.intro.config.IIntroContentProvider#dispose()
     */
    public void dispose() {
        // TODO Auto-generated method stub

    }
}
