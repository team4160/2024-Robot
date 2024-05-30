// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.net.PortForwarder;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autos.Spin;
import frc.robot.commands.Shooter.Ingest;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.Shooter.SpitOut;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static final CTREConfigs ctreConfigs = new CTREConfigs();

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  public static Shooter shooter = new Shooter();
  public static Intake intake = new Intake();
  public static Indexer indexer = new Indexer();
  public static Arm arm = new Arm();
  public PowerDistribution PD = new PowerDistribution(1, ModuleType.kRev);

  public final static XboxController operator = new XboxController(1);
  public JoystickButton toggle_intake = new JoystickButton(operator, XboxController.Button.kB.value);
  public JoystickButton toggle_slowshot = new JoystickButton(operator, XboxController.Button.kA.value);
  public JoystickButton toggle_fastshot = new JoystickButton(operator, XboxController.Button.kX.value);
  public JoystickButton stop = new JoystickButton(operator, XboxController.Button.kY.value);
  public JoystickButton primeLockButton = new JoystickButton(operator, XboxController.Button.kStart.value);
  public JoystickButton setLockButton = new JoystickButton(operator, XboxController.Button.kBack.value);
  public JoystickButton spitButton = new JoystickButton(operator, XboxController.Button.kLeftStick.value);

  // public AddressableLED m_led;
  // public AddressableLEDBuffer m_ledBuffer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    PortForwarder.add(5800, "photonvision.local", 5800);

    // m_led = new AddressableLED(9);
    // m_ledBuffer = new AddressableLEDBuffer(144);
    // m_led.setLength(m_ledBuffer.getLength());
    // m_led.setData(m_ledBuffer);
    // m_led.start();

    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    PD.clearStickyFaults();
    toggle_intake.onTrue(new Ingest(intake, indexer, shooter));
    toggle_slowshot.onTrue(new Shoot(intake, indexer, shooter, 10));
    toggle_fastshot.onTrue(new Shoot(intake, indexer, shooter, 60));
    spitButton.whileTrue(new SpitOut(intake, indexer, shooter));

    //cancel all commands when the stop button is pressed
    stop.onTrue(new InstantCommand( () -> CommandScheduler.getInstance().cancelAll()));
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    // rainbow();
    // m_led.setData(m_ledBuffer);
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    RobotContainer.s_Swerve.resetModulesToAbsolute();
    // m_robotContainer.autoChooser.getSelected().schedule();
    new Spin(RobotContainer.s_Swerve).schedule();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // shooter.shoot(operator.getRawAxis(1));
    // intake.setIntake(operator.getRawAxis(5));
    arm.setArm(deadband(operator.getRawAxis(XboxController.Axis.kRightY.value)) * -1);
  }

  private double deadband (double input) {
    if (input > -0.05 && input < 0.05)
      return 0; 
    return input;
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  // private int m_rainbowFirstPixelHue;
  // private void rainbow() {
  //   // For every pixel
  //   for (int i = 0; i < m_ledBuffer.getLength(); i++) {
  //     // Calculate the hue - hue is easier for rainbows because the color
  //     // shape is a circle so only one value needs to precess
  //     final int hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180;
  //     // Set the value
  //     m_ledBuffer.setHSV(i, hue, 255, 128);
  //   }
  //   // Increase by to make the rainbow "move"
  //   m_rainbowFirstPixelHue += 3;
  //   // Check bounds
  //   m_rainbowFirstPixelHue %= 180;
  // }
}