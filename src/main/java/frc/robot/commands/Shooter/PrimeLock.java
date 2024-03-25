package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lock;

public class PrimeLock extends Command {
    private final Lock lock;
    private final Timer timer1 = new Timer();
    private final Timer timer2 = new Timer();

    public PrimeLock(Lock lock) {
        this.lock = lock;
        addRequirements(lock);
    }

    @Override
    public void initialize() {
        // if (lock.isPrimed)
        //     cancel();
        timer2.stop();
        timer1.reset();
        timer2.reset();
        lock.setLock(-1);
        timer1.start();
    }

    @Override
    public void execute() {
        if (timer1.hasElapsed(11)) {
            lock.setLock(1);
            timer2.start();
        }
    }

    @Override
    public boolean isFinished() {
        return timer2.hasElapsed(5);
    }

    @Override
    public void end(boolean interrupted) {
        lock.setLock(0);
        lock.isPrimed = true;
    }
}
