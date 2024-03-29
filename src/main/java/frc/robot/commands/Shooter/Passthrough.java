package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Passthrough extends Command{
    private final Intake intake;
    private final Indexer indexer;
    private final Shooter shooter;
    double velocity;

    public Passthrough(Intake intake, Indexer indexer, Shooter shooter, double velocity) {
        this.intake = intake;
        this.indexer = indexer;
        this.shooter = shooter;
        addRequirements(intake);
        addRequirements(indexer);
        addRequirements(shooter);
        this.velocity = velocity;
    }

    @Override
    public void initialize() {
        shooter.shoot(velocity);
        indexer.setIndex(0.5);
        intake.setIntakeVelocity(velocity);
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntake(0);
        indexer.setIndex(0);
        shooter.stop();
    }
}
