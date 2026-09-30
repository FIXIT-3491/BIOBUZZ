package org.firstinspires.ftc.teamcode.FGC.Test;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Climber Test", group = "Test")
public class ClimberTest extends OpMode{

    private DcMotor climb;

    @Override
    public void init() {

        // Intake
        climb = hardwareMap.get(DcMotor.class, "climb");

    }

    @Override
    public void loop() {

        //intake
        if (gamepad1.right_trigger > 0.1) {
            climb.setPower(1);
        } else if (gamepad1.left_trigger > 0.1) {
            climb.setPower(-1);
        } else {
            climb.setPower(0);
        }

    }
}
