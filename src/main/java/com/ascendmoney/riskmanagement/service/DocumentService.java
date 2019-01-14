package com.ascendmoney.riskmanagement.service;

import com.ascendmoney.riskmanagement.entity.Template;
import com.ascendmoney.riskmanagement.repository.TemplateRepository;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService {
    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public void countryUserReject() {
        System.out.println("Country user reject document ...");
    }

    public void submitToCountry() {
        System.out.println("Business user create document ...");
    }

    public void submitToRegion() {System.out.println("Business user create document ...");}

    public Template save(Template template) {
        return templateRepository.save(template);
    }

    @Transactional
    public ProcessInstance startTemplateProcess(Template template) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("templateID", template.getId());
        variables.put("status","Pending");
        ProcessInstance process = runtimeService.startProcessInstanceByKey("DocumentApprove", variables);
        return process;
    }

    @Transactional
    public List<Task> getTasksByGroup(String group) {
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(group).list();
        System.out.println(tasks.size());
        return tasks;
    }

    public Map<String,Object> getVariablesOfProcess(String processID) {
        return runtimeService.getVariables(processID);
    }
}
