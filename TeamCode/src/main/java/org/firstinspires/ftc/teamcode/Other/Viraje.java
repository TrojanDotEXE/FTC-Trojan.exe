package org.firstinspires.ftc.teamcode.Other;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "Viraje", group = "Teste")

public class Viraje extends OpMode {

    DcMotor roataStanga, roataDreapta;

    @Override
    public void init()
    {
        //Motoare
        roataStanga  = hardwareMap.get(DcMotor.class, "motorStanga");
        roataDreapta = hardwareMap.get(DcMotor.class, "motorDreapta");

        roataDreapta.setDirection(DcMotorSimple.Direction.REVERSE);    //Directie motoare
        roataStanga.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    @Override
    public void loop()
    {

        double left;
        double right;

        double fata_spate = gamepad1.left_stick_y;
        double stanga_dreapta = gamepad1.right_stick_x;        //Range.clip?

        left = fata_spate - stanga_dreapta;
        right = fata_spate + stanga_dreapta;

        roataStanga.setPower(left);
        roataDreapta.setPower(right);

    }
}
