package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name="darshteleop", group = "Linear Opmode")
public class darshteleop extends LinearOpMode{
    
    hardwaremap hardware = new hardwaremap();

    @Override
    public void runOpMode(){
        hardware.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            DcMotorEx backLeftDrive;
            DcMotorEx backRightDrive;
            DcMotorEx frontLeftDrive;
            DcMotorEx frontRightDrive;

            backLeftDrive = hardwareMap.get(DcMotorEx.class, "back_left");
            backRightDrive = hardwareMap.get(DcMotorEx.class, "back_right");
            frontLeftDrive = hardwareMap.get(DcMotorEx.class, "front_left");
            frontRightDrive = hardwareMap.get(DcMotorEx.class, "front_right");

            double x = gamepad1.right_stick_x * 1.1;
            double y = -gamepad1.right_stick_y;
            double r = gamepad1.left_stick_x;

            double backLeftPower = y - x + r;
            double backRightPower = y + x - r;
            double frontLeftPower = y + x + r;
            double frontRightPower = y - x - r;

            double totalVelocity = backLeftDrive.getVelocity() + frontLeftDrive.getVelocity() + frontRightDrive.getVelocity() + backRightDrive.getVelocity();
            double singleMotorVelo = totalVelocity / 4;

            hardware.backLeftDrive.setPower(backLeftPower * 0.75);
            hardware.backRightDrive.setPower(backRightPower * 0.75);
            hardware.frontLeftDrive.setPower(frontLeftPower * 0.75);
            hardware.frontRightDrive.setPower(frontRightPower * 0.75);

            telemetry.addData("TotalVelo", "%.2f", totalVelocity);
            telemetry.addData("singleMotorVelo", "%.2f", singleMotorVelo);

            telemetry.addData("x", "%.2f", x);
            telemetry.addData("y", "%.2f", y);
            telemetry.addData("r", "%.2f", r);

            telemetry.addData("backLeftPower", "%.2f", backLeftPower);
            telemetry.addData("backRightPower", "%.2f", backRightPower);
            telemetry.addData("frontLeftPower", "%.2f", frontLeftPower);
            telemetry.addData("frontRightDrive", "%.2f", frontRightDrive);

            telemetry.update();


        }
    }
}
