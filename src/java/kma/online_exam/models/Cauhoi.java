package kma.online_exam.models;
// Generated Oct 9, 2020 11:19:13 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Cauhoi generated by hbm2java
 */
@Entity
@Table(name="cauhoi"
    ,catalog="onlineexam"
)
public class Cauhoi  implements java.io.Serializable {


     private int id;
     private String a;
     private String b;
     private String c;
     private String d;
     private String dapan;
     private String debai;
     private String dokho;
     private Monhoc monhoc;
     private Nhanvien nhanvien;

    public Cauhoi() {
    }

	
    public Cauhoi(String a, String b, String c, String dapan, String debai, String dokho, Monhoc monhoc, Nhanvien nhanvien) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.dapan = dapan;
        this.debai = debai;
        this.dokho = dokho;
        this.monhoc = monhoc;
        this.nhanvien = nhanvien;
    }
    public Cauhoi(String a, String b, String c, String d, String dapan, String debai, String dokho, Monhoc monhoc, Nhanvien nhanvien) {
       this.a = a;
       this.b = b;
       this.c = c;
       this.d = d;
       this.dapan = dapan;
       this.debai = debai;
       this.dokho = dokho;
       this.monhoc = monhoc;
       this.nhanvien = nhanvien;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="a", nullable=false)
    public String getA() {
        return this.a;
    }
    
    public void setA(String a) {
        this.a = a;
    }

    
    @Column(name="b", nullable=false)
    public String getB() {
        return this.b;
    }
    
    public void setB(String b) {
        this.b = b;
    }

    
    @Column(name="c", nullable=false)
    public String getC() {
        return this.c;
    }
    
    public void setC(String c) {
        this.c = c;
    }

    
    @Column(name="d")
    public String getD() {
        return this.d;
    }
    
    public void setD(String d) {
        this.d = d;
    }

    
    @Column(name="dapan", nullable=false)
    public String getDapan() {
        return this.dapan;
    }
    
    public void setDapan(String dapan) {
        this.dapan = dapan;
    }

    
    @Column(name="debai", nullable=false)
    public String getDebai() {
        return this.debai;
    }
    
    public void setDebai(String debai) {
        this.debai = debai;
    }

    
    @Column(name="dokho", nullable=false)
    public String getDokho() {
        return this.dokho;
    }
    
    public void setDokho(String dokho) {
        this.dokho = dokho;
    }

@ManyToOne()
    @JoinColumn(name="idmonhoc", nullable=false)
    public Monhoc getMonhoc() {
        return this.monhoc;
    }
    
    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }

@ManyToOne()
    @JoinColumn(name="usernameGV", nullable=false)
    public Nhanvien getNhanvien() {
        return this.nhanvien;
    }
    
    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }




}


