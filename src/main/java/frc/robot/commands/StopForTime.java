package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class StopForTime extends CommandBase {
    private final Drivetrain drivetrain;
    private final Timer timer = new Timer();
    private final double duration;

    public StopForTime(Drivetrain drivetrain, double duration) {
        this.drivetrain = drivetrain;
        this.duration = duration;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.stop(); // Stops the motors
        timer.reset();
        timer.start();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(duration);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
        timer.stop();
    }
}