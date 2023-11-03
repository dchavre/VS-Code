// @TeleOp or @Disabled determines whether the program will be shown in the driver hub

public class hardwaremap {
    // Define motors w/ DcMotorEx
    public DcMotorEx backLeftDrive;
    public DcMotorEx frontLeftDrive;
    public DcMotorEx backRightDrive;
    public DcMotorEx frontRightDrive;

    // May need to initialize more variables for other motors and mechanisms added onto the robot

    // Defining imu w/ the 
    public BNO055IMU imu; // initializes imu, imu consists of accelerometers: acceleration, gyroscopes: angular velocity, magnetometers: magnetic field surrounding the system
    public WebCamName camera; // Initializes variables

    // Empty method:
    public void hardwaremap() {

    }
    // Allows code to communicate with the robots hardware:
    public void init(HardwareMap hwMap) {

        // Matches physical hardware to robot config on driver screen:
        backLeftDrive = hwMap.get(DcMotorEx.class, "back_left");
        frontLeftDrive = hwMap.get(DcMotorEx.class, "front_left");
        backRightDrive = hwMap.get(DcMotorEx.class, "back_right");
        frontRightDrive = hwMap.get(DcMotorEx.class, "front_right");

        camera = hwMap.get(WebcamName.class, "Webcam 1"); // USB port
        imu = hwMap.get(BNO055IMU.class, "imu"); // I2C Bus 0 Port

        // Also needs to be done for other motors and mechanisms like servos, leds, etc.
        

        // Determining motor rotational direction: 
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE); // direction based on the physical orientation of the motors on the robot
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        
        // Setting power 0:
        backLeftDrive.setPower(0);
        frontLeftDriv.setPower(0);
        backRightDrive.setPower(0);
        frontRightDrive.setPower(0);

        // Will have to do this for all other motors and mechanisms added to the robot

        // Running all without encoder:
        backLeftDrive.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftDrive.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backRightDrive.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontRightDrive.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        // Will have to do this for all other motors and mechanisms added to the robot

        // Zero brake - as soon as power is released, causes the robot to ground itself, stopping immediately b/c inertia causes robot to move naturally after power release

        backLeftDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontLeftDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRightDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontRightDrive.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        // Will have to do this for all other motors and mechanisms added to the robot
    }



}