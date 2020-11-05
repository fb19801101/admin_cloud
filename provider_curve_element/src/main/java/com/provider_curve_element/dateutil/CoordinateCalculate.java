package com.provider_curve_element.dateutil;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-10-31 9:24
 */
public class CoordinateCalculate {
    /**
     * 功能：计算HY、YH点坐标
     *
     * @param _dk 交点里程
     * @param _x 交点坐标x
     * @param _y 交点坐标y
     * @param _x1 上一交点坐标y
     * @param _y1 下一交点坐标x
     * @param _x2 上一交点坐标x
     * @param _y2 下一交点坐标y
     * @param _Rc 圆曲线半径
     * @param _Lc 圆曲线长
     * @param _R1 上一曲线半径
     * @param _R2 下一曲线半径
     * @param _T1 上一切线长
     * @param _T2 下一切线长
     * @param _Ls1 上一缓和曲线长
     * @param _Ls2 下一缓和曲线长
     * @return HY坐标 X=ret[0] Y=ret[1] YH坐标 X=ret[2] Y=ret[3]
     */
    public static double[]  coordinate_HY_YH(double _dk, double _x, double _y, double _x1, double _y1, double _x2, double _y2, double _Rc, double _Lc, double _R1, double _R2, double _T1, double _T2, double _Ls1, double _Ls2){
        double jj1 = Math.atan2((_y - _y1), (_x - _x1)) * 180 / Math.PI;//第一方位角
        if (jj1 < 0) jj1 = 360 + jj1;
        double jj2 = Math.atan2((_y2 - _y), (_x2 - _x)) * 180 / Math.PI;//第二方位角
        if (jj2 < 0) jj2 = 360 + jj2;
        double zhuangjiao = jj1 - jj2;//转角，左转为正，右转为负
        double huanghe1qidianlc = _dk - _T1;
        double huanghe2zhongdianlc = huanghe1qidianlc + _Ls1 + _Ls2 + _Lc;
        double L1 = _Ls1;
        double L2 = _Ls2;

        double x011,y011,x01,y01,x0111,y0111;
        if (L1 != 0) {
            double Z1 = L1 - Math.pow(L1, 5) / (40 * _Rc * _Rc * L1 * L1)+Math.pow(L1, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(L1, 4));
            double Q1 = Math.pow(L1, 3) / (6 * _Rc * L1) - Math.pow(L1, 7) / (336 * Math.pow(_Rc, 3) * Math.pow(L1, 3));
            if (zhuangjiao < 0) {
                Q1 = -Q1;
            }
            double ZZ1 = Math.sqrt(Z1 * Z1 + Q1 * Q1);
            double jj31 = jj1 - Math.atan2(Q1, Z1) * 180 / Math.PI;
            x011 = _x + _T1 * Math.cos(Math.toRadians(jj1 - 180));
            y011 = _y + _T1 * Math.sin(Math.toRadians(jj1 - 180));
            x0111 = ZZ1 * Math.cos(Math.toRadians(jj31)) + x011;
            y0111 = ZZ1 * Math.sin(Math.toRadians(jj31)) + y011;

        } else {
            x011 = _x + _T1 * Math.cos(Math.toRadians(jj1 - 180));
            y011 = _y + _T1 * Math.sin(Math.toRadians(jj1 - 180));
            x0111 = x011;
            y0111 = y011;
        }

        double x012,y012,x02,y02,x0222,y0222;
        if(L2!=0){
            double Z2=L2-Math.pow(L2,5)/(40*_Rc*_Rc*L2*L2);
            double Q2=Math.pow(L2,3)/(6*_Rc*L2)-Math.pow(L2,7)/(336*Math.pow(_Rc,3)*Math.pow(L2,3));
            Q2=-Q2;
            if (zhuangjiao<0){
                Q2=-Q2;
            }
            double ZZ2=Math.sqrt(Z2*Z2+Q2*Q2);
            double jj32=jj2-Math.atan2(Q2,Z2)*180/Math.PI;
            x012=_x+_T2*Math.cos(Math.toRadians(jj2));
            y012=_y+_T2*Math.sin(Math.toRadians(jj2));
            x0222=ZZ2*Math.cos(Math.toRadians(jj32-180))+x012;
            y0222=ZZ2*Math.sin(Math.toRadians(jj32-180))+y012;
        } else {
            x012=_x+_T2*Math.cos(Math.toRadians(jj2));
            y012=_y+_T2*Math.sin(Math.toRadians(jj2));
            x0222=x012;
            y0222=y012;
        }

        double ls12=(_Rc*_Ls1)/(_R1-_Rc);//交点下第一段卵形曲线剩余长度
        double ls22=(_Rc*_Ls2)/(_R2-_Rc);//交点下第二段卵形曲线剩余长度
        double LS1=ls12+_Ls1;//交点下第一段卵形曲线还原后虚总长度
        double LS2=ls22+_Ls2;//交点下第二段卵形曲线还原后虚总长度
        double HEQD=huanghe1qidianlc-ls12;//交点下第一段卵形曲线还原后虚拟起点里程
        double HEZD=huanghe2zhongdianlc+ls22;//交点下第二段卵形曲线还原后虚拟终点里程
        double NN1=ls12-Math.pow(ls12,5)/(40*_Rc*_Rc*LS1*LS1)+Math.pow(ls12, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(LS1, 4));//第一卵形曲线起点投射至上虚拟轴线Y值
        double SS1=Math.pow(ls12,3)/(6*_Rc*LS1)-Math.pow(ls12,7)/(336*Math.pow(_Rc,3)*Math.pow(LS1,3));//第一卵形曲线起点投射至上虚拟轴线X值
        double NN2=ls22-Math.pow(ls22,5)/(40*_Rc*_Rc*LS2*LS2)+Math.pow(ls22, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(LS2, 4));//第二卵形曲线终点投射至上虚拟轴线Y值
        double SS2=Math.pow(ls22,3)/(6*_Rc*LS2)-Math.pow(ls22,7)/(336*Math.pow(_Rc,3)*Math.pow(LS2,3));//第二卵形曲线终点投射至上虚拟轴线X值
        double xluo01=_x+_T1*Math.cos(Math.toRadians(jj1-180));
        double yluo01=_y+_T1*Math.sin(Math.toRadians(jj1-180));//交点下第一段卵形曲线起点坐标
        double xluo02=_x+_T2*Math.cos(Math.toRadians(jj2));
        double yluo02=_y+_T2*Math.sin(Math.toRadians(jj2));//交点下第二段卵形曲线终点坐标

        double ZZluo11=Math.sqrt(NN1*NN1+SS1*SS1);//第一段卵形曲线起点至虚拟起点直线距离
        double IIluo1=(Math.pow(ls12,2)/(2*_Rc*LS1))*(180/Math.PI);//第一段卵形曲线起点偏角
        double IIluo2=Math.atan2(SS1,NN1)*180/Math.PI;
        double IIluo3=jj1+IIluo1-IIluo2-180;//第一卵形曲线起点至虚拟起点方位角

        double ZZluo22=Math.sqrt(NN2*NN2+SS2*SS2);
        double IIluo12=(Math.pow(ls22,2)/(2*_Rc*LS2))*(180/Math.PI);//第二段卵形曲线终点偏角
        double IIluo22=Math.atan2(SS2,NN2)*180/Math.PI;
        double IIluo32=jj2-IIluo12+IIluo22;

        if (zhuangjiao<0){
            IIluo3=jj1-IIluo1+IIluo2-180; //右偏时第一卵形曲线起点至虚拟起点方位角
            IIluo32=jj2+IIluo12-IIluo22;//右偏时虚拟终点至第二卵形曲线终点方位角
        }

        double xluo011=xluo01+ZZluo11*Math.cos(Math.toRadians(IIluo3));//交点下第一段卵形曲线还原后虚拟起点x坐标
        double yluo011=yluo01+ZZluo11*Math.sin(Math.toRadians(IIluo3));//交点下第一段卵形曲线还原后虚拟起点y坐标
        double IIxunifanwuj=jj1+IIluo1;//交点下第一段卵形曲线还原后虚拟轴线方位角
        double xluo022=xluo02+ZZluo22*Math.cos(Math.toRadians(IIluo32));//交点下第二段卵形曲线还原后虚拟起点x坐标
        double yluo022=yluo02+ZZluo22*Math.sin(Math.toRadians(IIluo32));//交点下第二段卵形曲线还原后虚拟起点y坐标
        double IIxunifanwuj2=jj2-IIluo12;//交点下第二段卵形曲线还原后虚拟轴线方位角

        if (zhuangjiao<0){
            IIxunifanwuj=jj1-IIluo1;
            IIxunifanwuj2=jj2+IIluo12;
        }
        double Zluo1=LS1-Math.pow(LS1,3)/(40*_Rc*_Rc)+Math.pow(LS1, 5) / (3456 * Math.pow(_Rc, 4));
        double Q1=Math.pow(LS1,2)/(6*_Rc)-Math.pow(LS1,4)/(336*Math.pow(_Rc,3));
        double I1=(Math.pow(LS1,2)/(2*_Rc*LS1))*(180/Math.PI);
        double JJ11=IIxunifanwuj-I1-90;

        double Zluo2=LS2-Math.pow(LS2,3)/(40*_Rc*_Rc)+Math.pow(LS2, 5) / (3456 * Math.pow(_Rc, 4));
        double Q2=Math.pow(LS2,2)/(6*_Rc)-Math.pow(LS2,4)/(336*Math.pow(_Rc,3));
        double I2=(Math.pow(LS2,2)/(2*_Rc*LS2))*(180/Math.PI);
        double JJ22=IIxunifanwuj2+I2-90;

        if (zhuangjiao<0){
            JJ11=IIxunifanwuj+I1-90;
            JJ22=IIxunifanwuj2-I2-90;
        }

        double ZZluo1=Math.sqrt(Zluo1*Zluo1+Q1*Q1);//第一卵形曲线待求点至虚拟原点距离
        double jjluo31=IIxunifanwuj-Math.atan2(Q1,Zluo1)*180/Math.PI;//第一卵形曲线待求点至虚拟原点方位角
        double ZZluo2=Math.sqrt(Zluo2*Zluo2+Q2*Q2);
        double jjluo32=IIxunifanwuj2-180+Math.atan2(Q2,Zluo2)*180/Math.PI;

        if (zhuangjiao<0){
            jjluo31=IIxunifanwuj+Math.atan2(Q1,Zluo1)*180/Math.PI;
            jjluo32=IIxunifanwuj2-180-Math.atan2(Q2,Zluo2)*180/Math.PI;
        }

        double xluo012=ZZluo1*Math.cos(Math.toRadians(jjluo31))+xluo011;
        double yluo012=ZZluo1*Math.sin(Math.toRadians(jjluo31))+yluo011; // 第一段卵形曲线待求点中心坐标

        double xluo023=ZZluo2*Math.cos(Math.toRadians(jjluo32))+xluo022;
        double yluo023=ZZluo2*Math.sin(Math.toRadians(jjluo32))+yluo022;//第二段卵形曲线待求点中心坐标

        if(_R1==0 && _R2==0){
            System.out.println("该段曲线要素输入有误，请检查");
        }
        if(_R1==0){
            x01=x0111;
            y01=y0111;
        }else {
            x01=xluo012;
            y01=yluo012;
        }
        if(_R2==0){
            x02=x0222;
            y02=y0222;
        }else {
            x02=xluo023;
            y02=yluo023;
        }

        double[] ret = new double[4];
        ret[0] = x01;
        ret[1] = y01;
        ret[2] = x02;
        ret[3] = y02;
        return ret;
    }

    /**
     * 功能：计算圆曲线上任一点的坐标
     *
     * @param dk 待算点里程
     * @param dist 待算点偏距
     * @param dk_HY 圆曲线起点里程
     * @param x_HY 圆曲线起点坐标x
     * @param y_HY 圆曲线起点坐标y
     * @param x_YH 圆曲线终点坐标x
     * @param y_YH 圆曲线终点坐标y
     * @param x_JD 交点坐标x
     * @param y_JD 交点坐标y
     * @param r 圆曲线半径
     * @return 待算点坐标 x=ret[0] y=ret[1]
     */
    public static double[]  coordinate_Circle_XY(double dk, double dist, double dk_HY, double x_HY, double y_HY, double x_YH, double y_YH, double x_JD, double y_JD, double r) {
        //该函数是计算圆曲线坐标函数
        //x_HY,y0是圆曲线起点坐标，x_YH,y1是圆曲线终点坐标，x_JD,y3是交点坐标，r是半径，yunangqulc是圆曲线起点里程，daiqiudianlc是待求点里程。
        double m = (x_YH * x_YH + y_YH * y_YH - x_HY * x_HY - y_HY * y_HY) / (2 * (x_YH - x_HY));
        double n = ((y_YH - y_HY) / (x_YH - x_HY));
        double c = (r * r - m * m - x_HY * x_HY + 2 * m * x_HY - y_HY * y_HY) * (-1);
        double a = n * n + 1;
        double b = 2 * (n * x_HY - y_HY - m * n);
        double y01 = ((-1 * b) + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double y02 = ((-1 * b) - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double x01 = m - y01 * n;
        double x02 = m - y02 * n;
        double r01 = Math.sqrt((x01 - x_JD) * (x01 - x_JD) + (y01 - y_JD) * (y01 - y_JD));
        double xyunxin, yyunxin, x, y;//xyunxin,yyunxin为圆心坐标，x,y为待求点坐标
        if (r01 > r) {
            yyunxin = y01;
            xyunxin = x01;
        } else {
            yyunxin = y02;
            xyunxin = x02;
        }
        double mm = dk - dk_HY;
        double jj1 = (mm * 360) / (2 * Math.PI * r);
        double jj = Math.atan2((y_HY - yyunxin), (x_HY - xyunxin)) * 180 / Math.PI;
        if(jj<0){
            jj=jj+360;
        }
        double jj3 = Math.atan2((y_JD - yyunxin), (x_JD - xyunxin)) * 180 / Math.PI;//交点到圆心方位角
        if(jj3<0){
            jj3=jj3+360;
        }
        double r10=r+dist;
        double jjjd_x0 = Math.atan2((y_JD - y_HY), (x_JD - x_HY)) * 180 / Math.PI;
        if(jjjd_x0<0){
            jjjd_x0=jjjd_x0+360;

        }
        double jjx1_jd = Math.atan2((y_YH - y_JD), (x_YH - x_JD)) * 180 / Math.PI;
        if(jjx1_jd<0){
            jjx1_jd=jjx1_jd+360;

        }
        if (jjjd_x0 > jjx1_jd){
            jj1 = -jj1;
            r10=r-dist;
            //System.out.println("顺时针，左偏");
        }else {
            //System.out.println("逆时针，右偏");
        }

        double jj2=jj+jj1;

        x=xyunxin+r10*Math.cos(Math.toRadians(jj2));
        y=yyunxin+r10*Math.sin(Math.toRadians(jj2));

        double[] ret = new double[2];
        ret[0] = x;
        ret[1] = y;
        return ret;
    }

    /**
     * 功能：计算直线上任一点的坐标
     *
     * @param dk 待算点里程
     * @param dist 待算点偏距
     * @param _dk 交点里程
     * @param _x 交点坐标x
     * @param _y 交点坐标y
     * @param _x1 上一交点x
     * @param _y1 上一交点y
     * @return 待算点坐标 x=ret[0] y=ret[1]
     */
    public static double[]  coordinate_Line_XY(double dk, double dist, double _dk, double _x, double _y, double _x1, double _y1){
        //该函数是计算直线坐标函数
        //_x1,y4是前一交点坐标，jiaodianlc是交点里程，_x,y3是交点坐标，daiqiudianlc是待求点里程。
        double jj=Math.atan2((_y1-_y),(_x1-_x))*180/Math.PI;
        double zz=_dk-dk;
        double x01=_x+zz*Math.cos(Math.toRadians(jj));
        double y01=_y+zz*Math.sin(Math.toRadians(jj));
        double x=x01+dist*Math.cos(Math.toRadians(jj+90));
        double y=y01+dist*Math.sin(Math.toRadians(jj+90));

        double[] ret = new double[2];
        ret[0] = x;
        ret[1] = y;
        return ret;
    }

    /**
     * 功能：计算缓和曲线上任一点的坐标
     *
     * @param dk 待算里程
     * @param dist 待算偏距
     * @param _dk 交点里程
     * @param _x 交点坐标x
     * @param _y 交点坐标y
     * @param _x1 上一交点坐标y
     * @param _y1 下一交点坐标x
     * @param _x2 上一交点坐标x
     * @param _y2 下一交点坐标y
     * @param _Rc 圆曲线半径
     * @param _Lc 圆曲线长
     * @param _T1 上一切线长
     * @param _T2 下一切线长
     * @param _Ls1 上一缓和曲线长
     * @param _Ls2 下一缓和曲线长
     * @return 待算点坐标 x=ret[0] y=ret[1]
     */
    public static double[]  coordinate_Trans_XY(double dk, double dist, double _dk, double _x, double _y, double _x1, double _y1, double _x2, double _y2, double _Rc, double _Lc, double _T1, double _T2, double _Ls1, double _Ls2){
        //该函数是计算缓和曲线坐标函数
        //_x1,y4是前一交点坐标，_dk，_x,y3是交点里程及坐标，r是半径，huanghechangdu是缓和曲线长度，qiexiang是切线长，yuangquxina是圆曲线长，daiqiudianlc是待求点里程，pianzhong是偏中距，左为+右为-。

        double jj1=Math.atan2((_y-_y1),(_x-_x1))*180/Math.PI;
        if(jj1<0)jj1=360+jj1;
        double jj2=Math.atan2((_y2-_y),(_x2-_x))*180/Math.PI;
        if(jj2<0)jj2=360+jj2;
        double zhuangjiao=jj1-jj2;//转角，左转为正，右转为负
        double huanghe1qidianlc=_dk-_T1;
        double huanghe2zhongdianlc=huanghe1qidianlc+_Ls1+_Ls2+_Lc;

        double L1=dk-huanghe1qidianlc;
        double L2=huanghe2zhongdianlc-dk;
        double Z1=L1-Math.pow(L1,5)/(40*_Rc*_Rc*_Ls1*_Ls1)+Math.pow(L1, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(L1, 4));
        double Z2=L2-Math.pow(L2,5)/(40*_Rc*_Rc*_Ls2*_Ls2)+Math.pow(L2, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(L2, 4));
        double Q1=Math.pow(L1,3)/(6*_Rc*_Ls1)-Math.pow(L1,7)/(336*Math.pow(_Rc,3)*Math.pow(_Ls1,3));
        double Q2=Math.pow(L2,3)/(6*_Rc*_Ls2)-Math.pow(L2,7)/(336*Math.pow(_Rc,3)*Math.pow(_Ls2,3));

        double I1=(Math.pow(L1,2)/(2*_Rc*_Ls1))*(180/Math.PI);
        double I2=(Math.pow(L2,2)/(2*_Rc*_Ls2))*(180/Math.PI);

        double jj11=jj1-I1-90;
        double jj22=jj2-90+I2;
        if (zhuangjiao<0){
            Q1=-Q1;
            Q2=-Q2;
            //dist = -dist;
            jj22=jj2-90-I2;
            jj11=jj1+I1-90;
        }
        double ZZ1=Math.sqrt(Z1*Z1+Q1*Q1);
        double ZZ2=Math.sqrt(Z2*Z2+Q2*Q2);

        double x01=_x+_T1*Math.cos(Math.toRadians(jj1-180));
        double y01=_y+_T1*Math.sin(Math.toRadians(jj1-180));

        double x02=_x+_T2*Math.cos(Math.toRadians(jj2));
        double y02=_y+_T2*Math.sin(Math.toRadians(jj2));

        double jj31=jj1-Math.atan2(Q1,Z1)*180/Math.PI;
        double x012=ZZ1*Math.cos(Math.toRadians(jj31))+x01;
        double y012=ZZ1*Math.sin(Math.toRadians(jj31))+y01;

        double jj32=jj2-180+Math.atan2(Q2,Z2)*180/Math.PI;
        double x022=ZZ2*Math.cos(Math.toRadians(jj32))+x02;
        double y022=ZZ2*Math.sin(Math.toRadians(jj32))+y02;

        double x1,y1,x2,y2,x,y;
        x1=x012+dist*Math.cos(Math.toRadians(jj11));
        y1=y012+dist*Math.sin(Math.toRadians(jj11));

        x2=x022+dist*Math.cos(Math.toRadians(jj22));
        y2=y022+dist*Math.sin(Math.toRadians(jj22));

        if(L1<_Ls1+0.05){
            x=x1;
            y=y1;
        }else {
            x=x2;
            y=y2;
        }

        double[] ret = new double[2];
        ret[0] = x;
        ret[1] = y;
        return ret;
    }

    /**
     * 功能：计算缓和曲线上任一点的坐标
     *
     * @param dk 待算里程
     * @param dist 待算偏距
     * @param _dk 交点里程
     * @param _x 交点坐标x
     * @param _y 交点坐标y
     * @param _x1 上一交点坐标y
     * @param _y1 下一交点坐标x
     * @param _x2 上一交点坐标x
     * @param _y2 下一交点坐标y
     * @param _Rc 圆曲线半径
     * @param _Lc 圆曲线长
     * @param _R1 上一曲线半径
     * @param _R2 下一曲线半径
     * @param _T1 上一切线长
     * @param _T2 下一切线长
     * @param _Ls1 上一缓和曲线长
     * @param _Ls2 下一缓和曲线长
     * @return 待算点坐标 x=ret[0] y=ret[1]
     */
    public static double[]  coordinate_Trans_XY(double dk, double dist, double _dk, double _x, double _y, double _x1, double _y1, double _x2, double _y2, double _Rc, double _Lc, double _R1, double _R2, double _T1, double _T2, double _Ls1, double _Ls2){
        double ls12=(_Rc*_Ls1)/(_R1-_Rc);//交点下第一段卵形曲线剩余长度
        double ls22=(_Rc*_Ls2)/(_R2-_Rc);//交点下第二段卵形曲线剩余长度
        double LS1=ls12+_Ls1;//交点下第一段卵形曲线还原后虚总长度
        double LS2=ls22+_Ls2;//交点下第二段卵形曲线还原后虚总长度

        double jj1=Math.atan2((_y-_y1),(_x-_x1))*180/Math.PI;//第一方位角
        if(jj1<0)jj1=360+jj1;
        double jj2=Math.atan2((_y2-_y),(_x2-_x))*180/Math.PI;//第二方位角
        if(jj2<0)jj2=360+jj2;
        double zhuangjiao=jj1-jj2;//转角，左转为正，右转为负
        double huanghe1qidianlc=_dk-_T1;//卵形曲线起点里程
        double huanghe2zhongdianlc=huanghe1qidianlc+_Ls1+_Ls2+_Lc;//卵形曲线终点里程

        double HEQD=huanghe1qidianlc-ls12;//交点下第一段卵形曲线还原后虚拟起点里程
        double HEZD=huanghe2zhongdianlc+ls22;//交点下第二段卵形曲线还原后虚拟终点里程

        double NN1=ls12-Math.pow(ls12,5)/(40*_Rc*_Rc*LS1*LS1)+Math.pow(ls12, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(LS1, 4));//第一卵形曲线起点投射至上虚拟轴线Y值
        double SS1=Math.pow(ls12,3)/(6*_Rc*LS1)-Math.pow(ls12,7)/(336*Math.pow(_Rc,3)*Math.pow(LS1,3));//第一卵形曲线起点投射至上虚拟轴线X值
        double NN2=ls22-Math.pow(ls22,5)/(40*_Rc*_Rc*LS2*LS2)+Math.pow(ls22, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(LS2, 4));//第二卵形曲线终点投射至上虚拟轴线Y值
        double SS2=Math.pow(ls22,3)/(6*_Rc*LS2)-Math.pow(ls22,7)/(336*Math.pow(_Rc,3)*Math.pow(LS2,3));//第二卵形曲线终点投射至上虚拟轴线X值

        double x01=_x+_T1*Math.cos(Math.toRadians(jj1-180));
        double y01=_y+_T1*Math.sin(Math.toRadians(jj1-180));//交点下第一段卵形曲线起点坐标
        double x02=_x+_T2*Math.cos(Math.toRadians(jj2));
        double y02=_y+_T2*Math.sin(Math.toRadians(jj2));//交点下第二段卵形曲线终点坐标

        double ZZ11=Math.sqrt(NN1*NN1+SS1*SS1);//第一段卵形曲线起点至虚拟起点直线距离
        double II1=(Math.pow(ls12,2)/(2*_Rc*LS1))*(180/Math.PI);//第一段卵形曲线起点偏角
        double II2=Math.atan2(SS1,NN1)*180/Math.PI;
        double II3=jj1+II1-II2-180;//第一卵形曲线起点至虚拟起点方位角

        double ZZ22=Math.sqrt(NN2*NN2+SS2*SS2);
        double II12=(Math.pow(ls22,2)/(2*_Rc*LS2))*(180/Math.PI);//第二段卵形曲线终点偏角
        double II22=Math.atan2(SS2,NN2)*180/Math.PI;
        double II32=jj2-II12+II22;

        if (zhuangjiao<0){
            II3=jj1-II1+II2-180; //右偏时第一卵形曲线起点至虚拟起点方位角
            II32=jj2+II12-II22;//右偏时虚拟终点至第二卵形曲线终点方位角
        }

        double x011=x01+ZZ11*Math.cos(Math.toRadians(II3));//交点下第一段卵形曲线还原后虚拟起点x坐标
        double y011=y01+ZZ11*Math.sin(Math.toRadians(II3));//交点下第一段卵形曲线还原后虚拟起点y坐标
        double IIxunifanwuj=jj1+II1;//交点下第一段卵形曲线还原后虚拟轴线方位角
        double x022=x02+ZZ22*Math.cos(Math.toRadians(II32));//交点下第二段卵形曲线还原后虚拟起点x坐标
        double y022=y02+ZZ22*Math.sin(Math.toRadians(II32));//交点下第二段卵形曲线还原后虚拟起点y坐标
        double IIxunifanwuj2=jj2-II12;//交点下第二段卵形曲线还原后虚拟轴线方位角

        if (zhuangjiao<0){
            IIxunifanwuj=jj1-II1;
            IIxunifanwuj2=jj2+II12;
        }
        double L1=dk-HEQD;//第一段卵形曲线待求点至虚拟起点弧线距离
        double Z1=L1-Math.pow(L1,5)/(40*_Rc*_Rc*LS1*LS1)+Math.pow(L1, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(L1, 4));
        double Q1=Math.pow(L1,3)/(6*_Rc*LS1)-Math.pow(L1,7)/(336*Math.pow(_Rc,3)*Math.pow(LS1,3));
        double I1=(Math.pow(L1,2)/(2*_Rc*LS1))*(180/Math.PI);
        double JJ11=IIxunifanwuj-I1-90;

        double L2=HEZD-dk;//第二段卵形曲线待求点至虚拟终点距离
        double Z2=L2-Math.pow(L2,5)/(40*_Rc*_Rc*LS2*LS2)+Math.pow(L2, 9) / (3456 * Math.pow(_Rc, 4)*Math.pow(L2, 4));
        double Q2=Math.pow(L2,3)/(6*_Rc*LS2)-Math.pow(L2,7)/(336*Math.pow(_Rc,3)*Math.pow(LS2,3));
        double I2=(Math.pow(L2,2)/(2*_Rc*LS2))*(180/Math.PI);
        double JJ22=IIxunifanwuj2+I2-90;

        if (zhuangjiao<0){
            JJ11=IIxunifanwuj+I1-90;
            JJ22=IIxunifanwuj2-I2-90;
        }

        double ZZ1=Math.sqrt(Z1*Z1+Q1*Q1);//第一卵形曲线待求点至虚拟原点距离
        double jj31=IIxunifanwuj-Math.atan2(Q1,Z1)*180/Math.PI;//第一卵形曲线待求点至虚拟原点方位角
        double ZZ2=Math.sqrt(Z2*Z2+Q2*Q2);
        double jj32=IIxunifanwuj2-180+Math.atan2(Q2,Z2)*180/Math.PI;

        if (zhuangjiao<0){
            jj31=IIxunifanwuj+Math.atan2(Q1,Z1)*180/Math.PI;
            jj32=IIxunifanwuj2-180-Math.atan2(Q2,Z2)*180/Math.PI;
        }

        double x012=ZZ1*Math.cos(Math.toRadians(jj31))+x011;
        double y012=ZZ1*Math.sin(Math.toRadians(jj31))+y011; // 第一段卵形曲线待求点中心坐标

        double x023=ZZ2*Math.cos(Math.toRadians(jj32))+x022;
        double y023=ZZ2*Math.sin(Math.toRadians(jj32))+y022;//第二段卵形曲线待求点中心坐标

        double x1,y1,x2,y2,x,y;
        x1=x012+dist*Math.cos(Math.toRadians(JJ11));
        y1=y012+dist*Math.sin(Math.toRadians(JJ11));//第一段卵形曲线待求点偏中坐标

        x2=x023+dist*Math.cos(Math.toRadians(JJ22));
        y2=y023+dist*Math.sin(Math.toRadians(JJ22));//第二段卵形曲线待求点偏中坐标

        if(L1<LS1+0.05){
            x=x1;
            y=y1;
        }else {
            x=x2;
            y=y2;
        }

        double[] ret = new double[2];
        ret[0] = x;
        ret[1] = y;
        return ret;
    }

    /**
     * 功能：坐标经纬度转换
     *
     * @param Xl 转换的坐标x
     * @param Yn 转换的坐标y
     * @param Tp 坐标系类型：1为1954北京坐标系，2为1980西安坐标系，3为WGS-84坐标系，4为2000国家坐标系
     * @param L0 中央子午线经度
     * @param H0 投影面高程
     * @return 经纬度度数组 L=ret[0] N=ret[1]
     *
     */
    public static double[] coordinateTransform(double Xl, double Yn, int Tp, double L0, double H0){
        double a=0; //a为坐标系椭球参数中地球长轴半径
        double b=0; //b为坐标系椭球参数中地球短轴半径

        if(Tp<=1) { //1954北京坐标系椭球参数
            a = 6378254;
            b = 6356863.01877304;
        } else if(Tp<=2) { //1980西安坐标系系椭球参数
            a = 6378140;
            b = 6356755.28815752;
        } else if(Tp<=3) { //WGS-84坐标系椭球参数
            a = 6378137;
            b = 6356752.3142;
        } else { //2000中国大地坐标系椭球参数
            a=6378137;
            b=6356752.3141;
        }

        a=a + H0;
        b=b + H0;

        double e1=Math.sqrt(a*a-b*b)/a; //第一偏心率e
        double e2=Math.sqrt(a*a-b*b)/b; //第二偏心率e2
        double c=a*a/b; //常数c
        double ee=e1*e1;
        double m0=a*(1-ee);
        double m2=(3*ee*m0)/2;
        double m4=(5*ee*m2)/4;
        double m6=(7*ee*m4)/6;
        double m8=(9*ee*m6)/8;
        double m10=(11*ee*m8)/10;

        double a0=m0+m2/2+3*m4/8+5*m6/16+35*m8/128;
        double a2=m2/2+m4/2+15*m6/32+7*m8/16;
        double a4=m4/8+3*m6/16+7*m8/32;
        double a6=m6/32+m8/16;
        double a8=m8/128;

        double xa0=a0*Math.PI/180;
        double Bf1=Xl/a0;//初始化Bf
        double bf;

        //按子午线弧长公式迭代计算
        double Bfi0=Bf1;
        double Bfi1;
        double FBfi0;
        while (true)
        {
            FBfi0=-a2*Math.sin(2*Bfi0)/2+a4*Math.sin(4*Bfi0)/4-a6*Math.sin(6*Bfi0)/6+a8*Math.sin(8*Bfi0)/8;
            Bfi1=(Xl-FBfi0)/a0;
            if(Math.abs(Bfi1-Bfi0)<Math.PI*Math.pow(10,-8)/(36*18))
                break;
            Bfi0=Bfi1;
        }
        bf=Bfi1;
        // double R1=2.518828476*0.001,R2=3.7009546*Math.pow(10,-6),R3=7.465*Math.pow(10,-9);//2000中国大地坐标系计算系数
        double Bf= bf;//底点纬度
        double tf=Math.tan(Bf);
        double sinBf=Math.sin(Bf);
        double cosBf=Math.cos(Bf);
        double nn22=e2*e2*cosBf*cosBf;//引入的符号
        double Wf=Math.sqrt(1-e1*e1*sinBf*sinBf);//引入的辅助函数
        double Vf=Math.sqrt(1+e2*e2*cosBf*cosBf);
        double Mf=a*(1-e1*e1)/Math.pow(Wf,3);//底点纬度下子午圈半径
        double y=Yn-500000;
        double Nf=a/Wf;//底点纬度下卯酉圈半径

        //经度:L,纬度:N
        double N=(Bf-(tf*y*y)/(2*Mf*Nf)+(tf*(5+3*tf*tf+nn22*nn22-9*nn22*nn22*tf*tf)*Math.pow(y,4))/(24*Mf*Math.pow(Nf,3))
                -(tf*(61+90*tf*tf+45*Math.pow(tf,4))*Math.pow(y,6))/(720*Mf*Math.pow(Nf,5)))*180/Math.PI;
        double l=y/(Nf*cosBf)-(1+2*tf*tf+nn22*nn22)*Math.pow(y,3)/(6*Math.pow(Nf,3))*cosBf+(5+28*tf*tf+24*Math.pow(tf,4))
                *Math.pow(y,5)/(120*Math.pow(Nf,5)*cosBf);
        double L=L0+l*180/Math.PI;


        int _d1 = (int)L;
        double _t1 = (L - _d1) * 60;
        int _m1 = (int) _t1;
        double _s1 = (_t1 - _m1) * 60;

        int _d2 = (int)N;
        double _t2 = (N - _d2) * 60;
        int _m2 = (int) _t2;
        double _s2 = (_t2 - _m2) * 60;
        String.format("经度L：%d度%d分%.3f秒  维度N：%d度%d分%.3f秒",_d1,_m1,_s1,_d2,_m2,_s2);

        double[] ret = new double[2];
        ret[0] = L;
        ret[1] = N;

        return ret;
    }

}
