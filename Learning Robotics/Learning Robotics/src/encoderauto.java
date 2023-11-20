package org.firstinspires.ftc.teamcode; // depends on directory of the class

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="encoder auto")

public class encoderauto extends LinearOpMode {
    
    // Declaring OpMode membrs
    hardwaremap robot = new hardwaremap(); //using hardware

    final double circumference = Math.PI*2.95;
    final double ticks = 560;

    @Override
    public void runOpMode() {
        // Initialize the drive system variables
        // init() method inside of the hardware class does all the work here

        robot.init(hardwareMap);

        // Sends telemetry message to show that the robot is waiting:
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Waiting for game to start (waiting for driver to press play):
        waitForStart();

        // Forward or backward (if you need to go backwards, you make the distance negative, the power is between -1, 1, but the absolute value is taken of it):
        driveForward(1, 12);
        driveStrafeRightorLeft(1, 24); // strafes to the right (note that it only works with mechanum wheels)
        driveStop(0); // Always needed to stop the robot

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    public void driveForward(double power, double distance) {
        // Reset all encoders:
        robot.backLeftDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeftDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);

        // Detemines the amount of motor rotations required to travel a distance:
        double rotationsNeeded = distance/circumference;

        // Determines the amount of ticks the motor has to run for to travel the entire distance:
        int encoderTarget = (int)(rotationsNeeded * ticks + 0.5);

        // Set target position:
        // setTargetPosition() gets the desired encoder target position at which the motor should move (back or forwards), and then holds its position

        robot.backLeftDrive.setTargetPosition(encoderTarget);
        robot.backRightDrive.setTargetPosition(encoderTarget);
        robot.frontLeftDrive.setTargetPosition(encoderTarget);
        robot.frontRightDrive.setTargetPosition(encoderTarget);

        // To reverse, set encoder target to negative
        // To strafe, set, to motors to a negative encoder target

        // Set power:
        robot.backLeftDrive.setPower(power);
        robot.backRightDrive.setPower(power);
        robot.frontLeftDrive.setPower(power);
        robot.frontRightDrive.setPower(power);

        // Run to position:
        robot.backLeftDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
        robot.frontRightDrive.setMode(Dc.RunMode.RUN_TO_POSITION);

        // Makes sure that no two motors havet he same position
        while (robot.frontLeftDrive.isBusy()) { 

        }
    }

// ONLY WORKS WITH MECHANUM WHEELS (THE DIAGONAL CYLLINDERS ON THE WHEELS)
    public void driveStrafeRightorLeft(double power, double distance) {
        // Resetting encoders
        robot.backLeftDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontLeftDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightDrive.setMode(Dc.RunMode.STOP_AND_RESET_ENCODER);

        // Detemines the amount of motor rotations required to travel a distance:
        double rotationsNeeded = distance/circumference;

        // Determines the amount of ticks the motor has to run for to travel the entire distance:
        int encoderTarget = (int)(rotationsNeeded * ticks + 0.5);

        // Set target position:
        // setTargetPosition() gets the desired encoder target position at which the motor should move (back or forwards), and then holds its position


        // Strafes right due to negating backLeft and front Right
        robot.backLeftDrive.setTargetPosition(-encoderTarget);
        robot.backRightDrive.setTargetPosition(encoderTarget);
        robot.frontLeftDrive.setTargetPosition(encoderTarget);
        robot.frontRightDrive.setTargetPosition(-encoderTarget);

        // To reverse, set encoder target to negative
        // To strafe, set, to motors to a negative encoder target

        // Set power:
        robot.backLeftDrive.setPower(power);
        robot.backRightDrive.setPower(power);
        robot.frontLeftDrive.setPower(power);
        robot.frontRightDrive.setPower(power);

        // Run to position:
        robot.backLeftDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
        robot.backRightDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
        robot.frontLeftDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
        robot.frontRightDrive.setMode(Dc.RunMode.RUN_TO_POSITION);
    }

    public void driveStop(double power) {
        robot.backLeftDrive.setPower(power);
        robot.backRightDrive.setPower(power);
        robot.frontLeftDrive.setPower(power);
        robot.frontRightDrive.setPower(power);
    }

}
