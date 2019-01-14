package com.ascendmoney.riskmanagement.controller;


import com.ascendmoney.riskmanagement.dto.TemplateDTO;
import com.ascendmoney.riskmanagement.entity.Template;
import com.ascendmoney.riskmanagement.service.DocumentService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DocumentProcessController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(value = "/start-template-process", produces = MediaType.APPLICATION_JSON_VALUE)
    public void startTemplateReviewProcess(@RequestBody TemplateDTO templateDTO) {
        Template template = new Template(templateDTO);
        documentService.save(template);
        documentService.startTemplateProcess(template);
    }

    @RequestMapping(value="/tasks", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<TemplateDTO> getTasksByGroup(@RequestParam String group) {
        List<Task> tasks = documentService.getTasksByGroup(group);
        List<TemplateDTO> templates = new ArrayList<>();
        for (Task task : tasks) {
            Map<String, Object> variables = task.getProcessVariables();
            Map<String, Object> localVariables = task.getTaskLocalVariables();
            Date createdTime = task.getCreateTime();

        }
        return null;
    }

    @RequestMapping(value="/process/", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> getVariablesOfProcess(@RequestParam String id) {
        Map<String,Object> vars = documentService.getVariablesOfProcess(id);
        return vars;
    }
}
