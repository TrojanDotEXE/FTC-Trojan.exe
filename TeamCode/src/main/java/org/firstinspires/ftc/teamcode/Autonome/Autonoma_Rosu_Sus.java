package org.firstinspires.ftc.teamcode.Autonome;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.HardwareM;

@Autonomous (name="Rosu_Sus",group="Autonome")
public class Autonoma_Rosu_Sus extends TemplateAutonoma
{
//    HardwareM fer = new HardwareM();

    @Override
    public void runOpMode() throws InterruptedException
    {
        fer.init(hardwareMap);
        telemetry.addData("Robot", "Iitializat");
        telemetry.update();

        waitForStart();
        while(opModeIsActive())
        {
            fer.roataDreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            fer.roataStanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            fer.roataDreapta.setTargetPosition(HardwareM.NEVEREST40_TICKS_PER_INCH*7);
            fer.roataStanga.setTargetPosition(HardwareM.NEVEREST40_TICKS_PER_INCH*7);

            fer.roataDreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            fer.roataStanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            fer.roataDreapta.setPower(.3);
            fer.roataStanga.setPower(.3);

            while(fer.roataStanga.isBusy() || fer.roataDreapta.isBusy()) {}
            fer.roataStanga.setPower(0);
            fer.roataDreapta.setPower(0);

//            fata_spate(.5,HardwareM.NEVEREST40_TICKS_PER_INCH*15);
            telemetry.addData("Rotatii", fer.roataStanga.getCurrentPosition());
            telemetry.addData("Rotatii", fer.roataDreapta.getCurrentPosition());
            telemetry.update();

            //segment 1:Dute la depozit si ia freight
                //1.1: intoarce te 90 de grade la dreapta
                //1.2: mergi fata pana la depozit cu fata
                //1.3: lasa bratul jos
                //1.4: activeaza peria si mergi putin in fata pentru a lua freight
                //1.1': intoarce te stanga 90 de grade
                //1.2':mergi pana la depozit cu spatele
            //segment 2: Du Freightul in team s.h.
                //2.1 ridica bratul la nivelul de jos al s.h.
                //2.2: intoarce te 90 grade stanga
                //2.3: mergi in fata pana in warehouse
                //2.4: intoarce te 90 de grade dreapta
                //2.5: mergi in fata pana la A5
                //2.6: intoarce te 90 grade stanga
                //2.7: mergi in fata pana la A4
                //2.8: te intorci 60 grade stanga
                //2.9: extinde brat si pune freightul pe stratul de jos
            //segment 3: loop depozit- s.h
                //3.1:  intoarce te 120 grade stanga
                //3.2: mergi in fata pana la depozit
                //3.3: lasa bratul jos
                //3.4: activeaza peria si mergi putin in fata pentru a lua freight
                //3.5: merg cu spatele pana la A4
                //3.6: ma intorc dreapta 120 grade
                //3.7: extinde brat si pune freightul pe stratul de jos
            //segment 4: parcheaza te
                //4.1: intoarce te 120 grade stanga
                //4.2: mergi in fata pana la A5
                //4.3: intoarce te 90 grade dreapta
                //4.4: mergi in fata pana in warehouse
        }
    }
}
