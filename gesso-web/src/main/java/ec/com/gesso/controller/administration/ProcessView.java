package ec.com.gesso.controller.administration;

import java.util.Collection;

import ec.com.gesso.model.entity.Job;
import ec.com.gesso.model.entity.Process;
import ec.com.gesso.model.entity.SubProcess;

public class ProcessView {
	private Process process ;
	private Collection<Process> lstProcesses;
	
	private SubProcess subProcess;
	private Job job;
	
	
	public ProcessView() {
		process = new Process();
		subProcess = new SubProcess();
		job = new Job();
	}
	
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public SubProcess getSubProcess() {
		return subProcess;
	}
	public void setSubProcess(SubProcess subProcess) {
		this.subProcess = subProcess;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}

	public Collection<Process> getLstProcesses() {
		return lstProcesses;
	}

	public void setLstProcesses(Collection<Process> lstProcesses) {
		this.lstProcesses = lstProcesses;
	}
	
	
}
