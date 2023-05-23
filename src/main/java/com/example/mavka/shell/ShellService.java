package com.example.mavka.shell;

import com.example.mavka.shell.model.Shell;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShellService {

    private final ShellRepository shellRepository;

    public ShellService(ShellRepository shellRepository) {
        this.shellRepository = shellRepository;
    }

    public List<Shell> getAllShells() {
        return shellRepository.returnallshells();
    }


    public Shell getShellById(long id) {
        return shellRepository.returnbuid(id);
    }
}
