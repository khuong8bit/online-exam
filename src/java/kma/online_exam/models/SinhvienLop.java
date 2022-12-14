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
 * SinhvienLop generated by hbm2java
 */
@Entity
@Table(name="sinhvienlop"
    ,catalog="onlineexam"
)
public class SinhvienLop  implements java.io.Serializable {


     private int id;
     private Lophoc lophoc;
     private Sinhvien sinhvien;

    public SinhvienLop() {
    }

	
    public SinhvienLop(int id) {
        this.id = id;
    }
    public SinhvienLop(int id, Lophoc lophoc, Sinhvien sinhvien) {
       this.id = id;
       this.lophoc = lophoc;
       this.sinhvien = sinhvien;
    }
   
     @Id 

    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne()
    @JoinColumn(name="classid")
    public Lophoc getLophoc() {
        return this.lophoc;
    }
    
    public void setLophoc(Lophoc lophoc) {
        this.lophoc = lophoc;
    }

@ManyToOne()
    @JoinColumn(name="masv")
    public Sinhvien getSinhvien() {
        return this.sinhvien;
    }
    
    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }




}


