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

public class Diona extends Obj_calculator{
    public Diona(Jszsg.AvatarInfoListDTO jszsg, List<Bl_cl> bl_cl, CharacterData du, Context context) {
        super(jszsg, bl_cl, du, context);

    }

    @Override
    void cshsz() {
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        ys_key="46";
        ysbf = getbl(q_level, 2, 1, 5);
    }

    @Override
    public List<Sh_data> csh() {
        myZy = new HashMap<>();
        zyList = new ArrayList<>();
        a_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(0).toString());
        q_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(2).toString());
        e_level = jszsg.getSkillLevelMap().get(du.getSkillOrder().get(1).toString());
        user_mz(mz);
        wq_syw_csh(jszsg, context, "46");
        enemy = new Enemy(Enemy.ELEMENT_WATER, 1000);
        List<Sh_data> data = new ArrayList<>();
        if (mz>=2)
            data.add(new Sh_data("E护盾吸收量",new double[]{(getbl(e_level,1,1,1)*getSmz(0)+getbl(e_level,1,3,1))*(1+myZy.get("10054"))*1.75,0}));
       else
            data.add(new Sh_data("E护盾吸收量",new double[]{(getbl(e_level,1,1,1)*getSmz(0)+getbl(e_level,1,3,1))*0.75,0}));

        data.add(new Sh_data("Q治疗量",new double[]{(getbl(q_level,2,1,2)*getSmz(0)+getbl(q_level,2,3,2))*1+getCure(),0}));

        return data;
    }

    @Override
    public double[] user_a(int a) {
        return new double[0];
    }

    @Override
    public double[] user_q() {
        return new double[0];
    }

    @Override
    public double[] user_e() {
        return new double[0];
    }

    @Override
    public void user_mz(int mz) {
        switch (mz) {

            case 6:
            case 5:
                if (e_level < 11)
                    e_level += 3;
            case 4:
            case 3:
                if (q_level < 11)
                    q_level += 3;
            case 2:
                if (!addZy(new Zy(0.15, "二命", false, false, "10054", 0, 0))) {
                    accumulateValue("10054", 0.15);
                }
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
