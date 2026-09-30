package org.firstinspires.ftc.teamcode.FGC.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "EddyTest", group = "GeneralTest")
public class EddyTest extends OpMode {

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

    // Servo positions
    private static final double BOX_UP = 0.0;
    private static final double BOX_DOWN = 1.0;
    private static final double BOX_UP1 = 0.0;
    private static final double BOX_DOWN1 = 1.0;

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
        boxServo1.setPosition(BOX_UP1);
    }

    @Override
    public void loop() {

        //scissor lift
        if (gamepad1.dpad_up) {
            liftLeft.setPower(0.5);
            liftRight.setPower(0.5);

        } else if (gamepad1.dpad_down) {
            liftLeft.setPower(-0.5);
            liftRight.setPower(-0.5);

        } else {
            liftLeft.setPower(0);
            liftRight.setPower(0);
        }

        //box
        if (gamepad1.dpad_right) {
            boxServo.setPosition(BOX_DOWN);
            boxServo1.setPosition(BOX_DOWN1);
        } else if (gamepad1.dpad_left) {
            boxServo.setPosition(BOX_UP);
            boxServo1.setPosition(BOX_UP1);
        }

        // drive motors
        if (gamepad2.a) {
            brDrive.setPower(0.7);
        } else if (gamepad2.b) {
            frDrive.setPower(0.7);
        } else if (gamepad2.x) {
            blDrive.setPower(0.7);
        } else if (gamepad2.y) {
            flDrive.setPower(0.7);
        } else {
            brDrive.setPower(0);
            frDrive.setPower(0);
            blDrive.setPower(0);
            flDrive.setPower(0);
        }

        //intake
        if (gamepad1.right_trigger > 0.1) {
            intake.setPower(1);
        } else if (gamepad1.left_trigger > 0.1) {
            intake.setPower(-1);
        } else {
            intake.setPower(0);
        }

        //climb
        if (gamepad1.right_bumper) {
            climb.setPower(1);
        } else if (gamepad1.left_bumper) {
            climb.setPower(-1);
        } else {
            climb.setPower(0);
        }
    }
}
