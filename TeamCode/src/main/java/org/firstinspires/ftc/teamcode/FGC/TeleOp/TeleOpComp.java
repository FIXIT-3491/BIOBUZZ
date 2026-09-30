package org.firstinspires.ftc.teamcode.FGC.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleOp (FGC Competition)", group = "Comp")
public class TeleOpComp extends OpMode {

    // Drive motors
    private DcMotor intake;
    private DcMotor blDrive;
    private DcMotor flDrive;
    private DcMotor brDrive;
    private DcMotor frDrive;

    // Scissor lift motors
    private DcMotor liftLeft;
    private DcMotor liftRight;

    // Climb motor
    private DcMotor climb;

    // Box servo
    private Servo boxServo;
    private Servo boxServo1;

    // Box servo positions
    private static final double BOX_UP = 0.0;
    private static final double BOX_DOWN = 1.0;

    @Override
    public void init() {

        // Intake
        intake = hardwareMap.get(DcMotor.class, "intake");

        // Drive motors
        brDrive = hardwareMap.get(DcMotor.class, "backRight");
        blDrive = hardwareMap.get(DcMotor.class, "BackLeft");
        flDrive = hardwareMap.get(DcMotor.class, "frontLeft");
        frDrive = hardwareMap.get(DcMotor.class, "frontRight");

        // Scissor lift motors
        liftLeft = hardwareMap.get(DcMotor.class, "leftLift");
        liftRight = hardwareMap.get(DcMotor.class, "rightLift");

        liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Climb motor
        climb = hardwareMap.get(DcMotor.class, "climb");

        climb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Box servo
        boxServo = hardwareMap.get(Servo.class, "boxServo");
        boxServo1 = hardwareMap.get(Servo.class, "boxServo1");

        // Start with box up
        boxServo.setPosition(BOX_UP);
        boxServo1.setPosition(BOX_UP);

    }

    @Override
    public void loop() {

        double leftPower = -gamepad1.left_stick_y;
        double rightPower = -gamepad1.right_stick_y;

        // Left side
        flDrive.setPower(leftPower);
        blDrive.setPower(leftPower);

        // Right side
        frDrive.setPower(rightPower);
        brDrive.setPower(rightPower);

        // Scissor Lift
        if (gamepad2.dpad_up) {
            liftLeft.setPower(0.5);
            liftRight.setPower(0.5);
        } else if (gamepad2.dpad_down) {
            liftLeft.setPower(-0.5);
            liftRight.setPower(-0.5);
        } else {
            liftLeft.setPower(0);
            liftRight.setPower(0);
        }

        // Box servo
        if (gamepad2.dpad_right) {
            boxServo.setPosition(BOX_DOWN);
            boxServo1.setPosition(BOX_DOWN);
        } else if (gamepad2.dpad_left) {
            boxServo.setPosition(BOX_UP);
            boxServo1.setPosition(BOX_DOWN);
        }

        //intake
        if (gamepad1.right_trigger > 0.1) {
            intake.setPower(1.0);
        } else if (gamepad2.left_trigger > 0.1) {
            intake.setPower(-1.0);
        } else {
            intake.setPower(0);
        }

        // climb
        if (gamepad2.right_bumper) {
            climb.setPower(1.0);
        } else if (gamepad2.left_bumper) {
            climb.setPower(-1.0);
        } else {
            climb.setPower(0);
        }

    }
}
