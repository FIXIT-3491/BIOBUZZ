package org.firstinspires.ftc.teamcode.FGC.Test;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Intake Test", group = "Test")
public class IntakeTest extends OpMode{

    private DcMotor intake;

    @Override
    public void init() {

        // Intake
        intake = hardwareMap.get(DcMotor.class, "intake");

    }

    @Override
    public void loop() {

        //intake
        if (gamepad1.right_trigger > 0.1) {
            intake.setPower(1);
        } else if (gamepad1.left_trigger > 0.1) {
            intake.setPower(-1);
        } else {
            intake.setPower(0);
        }

    }
}
