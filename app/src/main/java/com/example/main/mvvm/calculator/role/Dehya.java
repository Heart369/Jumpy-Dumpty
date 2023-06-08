package com.example.main.mvvm.calculator.role;

import android.content.Context;

import com.example.main.mvvm.calculator.tool.Enemy;
import com.example.main.mvvm.calculator.tool.Sh_data;
import com.example.main.mvvm.calculator.tool.Zy;
import com.example.main.mvvm.json.CharacterData;
import com.example.main.raw.Class_Custom.Bl_cl;
import com.example.main.raw.JsonPares.Jszsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dehya extends Obj_calculator {
    public Dehya(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);
    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key = "40";
        ysbf = getbl(q_level, 2, 1, 4);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "40");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        data.add(new Sh_data("E协同", user_e()));
        data.add(new Sh_data("Q一套", user_q()));
        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        double[] d;
        if (mz==6){
            accumulateValue("20",0.1);
            accumulateValue("22",0.15);
        }
        double sh_ysh = ((getGj(0) * getbl(q_level, 2, 1, 0) + getSmz(0) * getbl(q_level, 2, 3, 0) + getJc("30040", "10024")) * getZs("40", "10003")) * getFy() * getYsKx("40") * 10;
        sh_ysh += ((getGj(0) * getbl(q_level, 2, 1, 1) + getSmz(0) * getbl(q_level, 2, 3, 1) + getJc("30040", "10024")) * getZs("40", "10003")) * getFy() * getYsKx("40");
        d = getqw("100040", sh_ysh, 2);
        if (mz==6){
            accumulateValue("20",-0.1);
            accumulateValue("22",-0.15);
        }
        return d;
    }

    @Override
    public double[] user_e() {
        double[] d;
        double sh_ysh = ((getGj(0) * getbl(e_level, 1, 1, 2) + getSmz(0) * getbl(e_level, 1, 3, 2) + getJc("30040", "10023")) * getZs("40", "10002")) * getFy() * getYsKx("40");
        d = getqw("100040", sh_ysh, 1);
        return d;
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {
            case 6:

            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
                //        if (!addZy(new Zy(0.33, "固有天赋一", true, false, "40", 0, 0))) {
//            accumulateValue("40", 0.33);
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(0.5, "2命", true, false, "10002", 0, 0)))
                    accumulateValue("10002", 0.5);
            case 1:
                if (!addZy(new Zy(0.2, "1命_1", true, false, "3", 0, 0)))
                    accumulateValue("3", 0.2);
                if (!addZy(new Zy(getSmz(0) * 0.036, "1命_2", true, false, "10023", 0, 0)))
                    accumulateValue("10023", getSmz(0) * 0.036);
                if (!addZy(new Zy(getSmz(0) * 0.06, "1命_3", true, false, "10024", 0, 0)))
                    accumulateValue("10024", getSmz(0) * 0.06);
        }
    }

    @Override
    public void g1() {

    }

    @Override
    public void g2() {

    }

    @Override
    public void g3() {

    }
}
