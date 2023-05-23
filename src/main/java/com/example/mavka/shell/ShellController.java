package com.example.mavka.shell;

import com.example.mavka.shell.model.Shell;
import com.example.mavka.shell.model.ShellBrief;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShellController {

    private final ShellService shellService;

    public ShellController(ShellService shellService) {
        this.shellService = shellService;
    }

    @GetMapping("/shells")
    public List<ShellBrief> getAllShells() {
        return shellService.getAllShells()
                .stream()
                .map(shell -> new ShellBrief(shell.id(), shell.name(), shell.name_of_shell()))
                .toList();
    }

    @GetMapping("/shells/{id}")
    public Shell getShellById(@PathVariable long id) {
        return shellService.getShellById(id);
    }
}
