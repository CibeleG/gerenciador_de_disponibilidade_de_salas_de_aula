package service;

import entities.Turma;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Aluno extends Pessoa 
{
    private String curso;
    private ArrayList <Turma> turmas = new ArrayList<Turma>();

    public ArrayList<Turma> getTurmas() 
    {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) 
    {
        this.turmas = turmas;
    }

    public String getCurso() 
    {
        return curso;
    }

    public void setCurso(String curso) 
    {
        this.curso = curso;
    }
    
    public void criaDiretAluno()
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome()+"//pessoa", "aluno");
        boolean jk = Insti.mkdir();
        File Al = new File(Insti, this.getNome());
        boolean pf = Al.mkdir();
    }
    
    public void criarDiretTurma()
    {
        File Insti = new File("diretorio//inst//"+this.Inst.getNome()+"//pessoa//aluno//"+this.getNome(),"turmas");
        boolean jk = Insti.mkdir();
    }
    
    public void salvaLisTurma(Turma T)
    {
        try 
        {
            FileWriter lt = new FileWriter("diretorio//inst//"+this.Inst.getNome()+"//pessoa//aluno//"+this.getNome()+"//lista.txt",true);
            PrintWriter plt = new PrintWriter(lt);
            plt.println(T.getNome());

            plt.flush();
            plt.close();//fecha a escrita
            lt.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvaLisAluno()
    {
        try 
        {
            FileWriter lt = new FileWriter("diretorio//inst//"+this.Inst.getNome()+"//pessoa//aluno//lista.txt",true);
            PrintWriter plt = new PrintWriter(lt);
            plt.println(this.getNome());

            plt.flush();
            plt.close();//fecha a escrita
            lt.close();//fecha o arquivo
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String SalvarTurma(Turma T)
    {
        try 
        {
            FileWriter fwT = new FileWriter("diretorio//inst//"+this.Inst.getNome()+"//pessoa//aluno//"+this.getNome()+"//"+T.getNome()+"//"+T.getNome()+".txt");
            PrintWriter pwT = new PrintWriter(fwT);
            pwT.println(T.getDisciplina().getNome());
            pwT.println(T.getProfessor().getNome());
            pwT.println(T.getNome());
            pwT.println(T.getNumAlunos());
            pwT.println(T.getNumDiasSema());
            pwT.flush();
            pwT.close();
            fwT.close();
        }  
        catch (IOException ex) 
        {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return "Alteração feita";
    }
    
    public String Salvar()
    {
         
        try 
        {
            FileWriter fw = new FileWriter("diretorio//inst//"+this.Inst.getNome()+"//pessoa//aluno//"+this.getNome()+"//"+this.getNome()+".txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.Inst);
            pw.println(this.getNome());
            pw.println(this.getCurso());
            pw.flush();
            pw.close();
            fw.close(); 
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Aluno.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return "Alteração feita";
    }
}
