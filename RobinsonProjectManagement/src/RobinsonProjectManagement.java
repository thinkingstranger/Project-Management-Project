
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * James Robinson, Hugh Tuckwell, and not Sam 5/6/22 you will be creating a Java
 * program which will help your sister study for her SDLC test. Your system must
 * include points to study from, as well as a multiple choice quiz (10
 * questions) for practice, which will be automatically graded and feedback
 * given. These study notes and questions must be read from external files (so
 * they can easily be updated). You and your partner(s) will be using the stages
 * of the SDLC to complete this project. To change this license header, choose
 * License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
/**
 *
 * @author jarob3698
 */
public class RobinsonProjectManagement extends javax.swing.JFrame {
    boolean answers[];
    Question[] questions;
    int currentQuestion = 0;
    boolean stop = false;
    int currentNotes = 0;
    ArrayList<String> notesList;
    /**
     * Creates new form RobinsonProjectManagement
     */
    /**
     *
     */
    public RobinsonProjectManagement() {
        initComponents();
        /**
         * import the file and save it to an array of question objects
         */
        try {
            File file1 = new File("src/questions.txt");
            Scanner scanner = new Scanner(file1);
            //while the file has lines left, store those lines to the array at the incrementer
            String firstLine = scanner.nextLine();
            questions = new Question[Integer.parseInt(firstLine)];
            answers = new boolean[Integer.parseInt(firstLine)];
            for (int i = 0; i < Integer.parseInt(firstLine); i++) {
                Question temp = new Question();
                temp.setQuestion(scanner.nextLine());
                for (int j = 0; j < 4; j++) {
                    temp.setAnswer(scanner.nextLine(), j);
                }
                temp.setCorrectAnswer(Integer.parseInt(scanner.nextLine()) - 1);
                questions[i] = temp;
            }
                
            
             File file2 = new File("src/notes.txt");
            Scanner scanner2 = new Scanner(file2);
            
            notesList = new ArrayList();
            
            while (scanner2.hasNextLine()){
                notesList.add(scanner2.nextLine());
            }
            
            txtNotes.setText(notesList.get(currentNotes));
            System.out.println(questions);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

    }

    public int buttonCheck() {
        int i = 0;
        if (btnAnswer1.isSelected()) {
            i = 0;
        }
        if (btnAnswer2.isSelected()) {
            i = 1;
        }
        if (btnAnswer3.isSelected()) {
            i = 2;
        }
        if (btnAnswer4.isSelected()) {
            i = 3;
        }
        return i;
    }

    public boolean runQuestion(Question q) {
        return (q.getCorrectAns() == buttonCheck());
    }
    public void displayQuestion(Question q){
        btnGroupAnswers.clearSelection();
        String strOutput = "Current Question:" + currentQuestion + "\n" + q.getQuestion() + "\n";
        int numQuestions = questions.length;
        for (int i = 0; i < 4; i++) {
            strOutput += (i + 1) + ": " + q.getAnswer(i) + "\n";
        }
        txtQuiz.setText(strOutput);
    }
    
    public void changeQuestion(int i){
        currentQuestion += i;
        if (currentQuestion < 0){
            currentQuestion = questions.length - 1;
        }
        if (currentQuestion >= questions.length){
            currentQuestion = 0;
        }
        displayQuestion(questions[currentQuestion]);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAnswers = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuiz = new javax.swing.JTextArea();
        btnAnswer1 = new javax.swing.JRadioButton();
        btnAnswer2 = new javax.swing.JRadioButton();
        btnAnswer3 = new javax.swing.JRadioButton();
        btnAnswer4 = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnStart1 = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQuiz.setColumns(20);
        txtQuiz.setRows(5);
        jScrollPane1.setViewportView(txtQuiz);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 290, 270));

        btnGroupAnswers.add(btnAnswer1);
        btnAnswer1.setText("Answer 1");
        getContentPane().add(btnAnswer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, -1, -1));

        btnGroupAnswers.add(btnAnswer2);
        btnAnswer2.setText("Answer 2");
        btnAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswer2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnswer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, -1, -1));

        btnGroupAnswers.add(btnAnswer3);
        btnAnswer3.setText("Answer 3");
        getContentPane().add(btnAnswer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, -1, -1));

        btnGroupAnswers.add(btnAnswer4);
        btnAnswer4.setText("Answer 4");
        getContentPane().add(btnAnswer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, -1, -1));

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, -1, -1));

        btnEnd.setText("End Quiz");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, -1, -1));

        txtNotes.setColumns(20);
        txtNotes.setRows(5);
        jScrollPane2.setViewportView(txtNotes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 310, 270));

        btnLeft.setText("<<<");
        getContentPane().add(btnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        btnRight.setText(">>>");
        getContentPane().add(btnRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        btnStart1.setText("Start Quiz");
        btnStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        btnQuit.setText("Quit");
        getContentPane().add(btnQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 130, 70));

        lblTitle.setText("Study and Practice Test!");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        answers[currentQuestion] = runQuestion(questions[currentQuestion]);
        changeQuestion(-1);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        answers[currentQuestion] = runQuestion(questions[currentQuestion]);
        changeQuestion(+1);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnswer2ActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        // TODO add your handling code here:
        String strOutput = "Correct Answers: ";
        int correctAnswers = 0;
        String str = "";
        for (int i = 0; i < answers.length; i++) {
            if(answers[i]){
                correctAnswers++;
                str+= "correct";
            }else{
                str+= "incorrect";
            }
            if(i < answers.length - 1){
                str+= ", ";
            }
        }
        strOutput += correctAnswers;
        strOutput += "\n" + str;
        txtQuiz.setText(strOutput);
        
    }//GEN-LAST:event_btnEndActionPerformed
    
    private void btnStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart1ActionPerformed
        // TODO add your handling code here:
        System.out.println(questions[currentQuestion].toString());
        displayQuestion(questions[currentQuestion]);
        
        
    }//GEN-LAST:event_btnStart1ActionPerformed
private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        currentQuestion++;
        if (currentQuestion != notesList.size()){
            txtNotes.setText(notesList.get(currentQuestion));
        } else {
            currentQuestion--;
        }
        
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        currentQuestion--;
        if (currentQuestion >= 0){
            txtNotes.setText(notesList.get(currentQuestion));
        } else {
            currentQuestion++;
        }
    }//GEN-LAST:event_btnLeftActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RobinsonProjectManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RobinsonProjectManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RobinsonProjectManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RobinsonProjectManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RobinsonProjectManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAnswer1;
    private javax.swing.JRadioButton btnAnswer2;
    private javax.swing.JRadioButton btnAnswer3;
    private javax.swing.JRadioButton btnAnswer4;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEnd;
    private javax.swing.ButtonGroup btnGroupAnswers;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnStart1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextArea txtQuiz;
    // End of variables declaration//GEN-END:variables
}
