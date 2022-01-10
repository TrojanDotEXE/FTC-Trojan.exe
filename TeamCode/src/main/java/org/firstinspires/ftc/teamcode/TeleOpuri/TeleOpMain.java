package org.firstinspires.ftc.teamcode.TeleOpuri;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.Hardware.HardwareM;


@TeleOp(name = "TeleOP", group = "Teste")

public class TeleOpMain extends OpMode
{
    HardwareM fer = new HardwareM();    //Variabile

    @Override
    public void init()
    {
        fer.init(hardwareMap, false);
        telemetry.addData("Robot" ,"Initializat");
    }

    @Override
    public void loop()
    {
        //Gamepad 1

        //Variabilele motoare roti
        double left;
        double right;
        double fata_spate = Range.clip(gamepad1.left_stick_y, -1, 1);
        double stanga_dreapta = Range.clip(gamepad1.right_stick_x, -1, 1);


        left = fata_spate - stanga_dreapta;
        right = fata_spate + stanga_dreapta;

        fer.roataStanga.setPower(left);
        fer.roataDreapta.setPower(right);

        //Carusel
        if(gamepad1.right_bumper) fer.carusel.setPower(1);      //!Directie corespondenta cu bumperul

        else if(gamepad1.left_bumper) fer.carusel.setPower(-1);

             else fer.carusel.setPower(0);

        //Gamepad 2 (left_stick, right_stick, b, y, l_bumper, r_bumper)

        //Brat
        if(gamepad2.b)
        {
            fer.brat_D.setPower(Range.clip(gamepad2.left_stick_y, -.5, .5));
            fer.brat_S.setPower(Range.clip(gamepad2.left_stick_y, -.5, .5));
            telemetry.addData("Slowmode","Activat");
        }
        else
        {
            fer.brat_D.setPower(Range.clip(gamepad2.left_stick_y, -.7, .7));
            fer.brat_S.setPower(Range.clip(gamepad2.left_stick_y, -.7, .7));
            telemetry.addData("Slowmode", "Dezactivat");
        }

        //Scipete
        fer.brat_A.setPower(Range.clip(gamepad2.right_stick_y, -1, 1));
        //telemetry.addData("Rotatii", );

        if(gamepad2.y)
        {
            fer.goToPosition(fer.nr_rotiri_scripete, 1, fer.brat_A);

            while(fer.brat_A.isBusy()) {}
            fer.brat_A.setPower(0);
        }

        //Peria
        if(gamepad2.left_bumper)
            {
                fer.peria.setPower(1);
                telemetry.addData("Perie","Spate");
            }
        else if(gamepad2.right_bumper)
            {
                fer.peria.setPower(-1);
                telemetry.addData("Perie","Fata");
            }
            else
                {
                    fer.peria.setPower(0);
                    telemetry.addData("Perie","Oprita");
                }
        telemetry.update();
    }
}