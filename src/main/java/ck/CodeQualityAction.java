package ck;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;

import org.jfree.ui.RefineryUtilities;

public class CodeQualityAction extends AnAction {

    public String path = "";

    public CodeQualityAction() {
        super("CodeQuality");
    }

    public void actionPerformed(AnActionEvent event) {

        PsiClass psiClass = getPsiClassFromContext(event);

        CKReport report = new CK().calculate(path);

        CreateChart chart = new CreateChart("CK Quality Metrics", "Metrics for class: " + psiClass.getName(), report, psiClass);
//        chart.pack();
//        RefineryUtilities.centerFrameOnScreen(chart);
//        chart.setVisible( true );

        ThreadExecution te = new ThreadExecution(path, chart);
        Thread t1 = new Thread(te);
        t1.start();

    }

    @Override
    public void update(AnActionEvent e) {
        PsiClass psiClass = getPsiClassFromContext(e);
        e.getPresentation().setEnabled(psiClass != null);
    }

    private PsiClass getPsiClassFromContext(AnActionEvent e) {
        PsiFile psiFile = e.getData(LangDataKeys.PSI_FILE);
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (psiFile == null || editor == null) {
            return null;
        }
        int offset = editor.getCaretModel().getOffset();
        PsiElement elementAt = psiFile.findElementAt(offset);
        PsiClass psiClass = PsiTreeUtil.getParentOfType(elementAt, PsiClass.class);

        path = psiFile.getVirtualFile().getParent().getCanonicalPath();
        return psiClass;
    }
}
