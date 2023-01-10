package com.example.demoLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequestMapping("")
public class LabControler {
    @Autowired
    private LabService labService;

    @GetMapping("/data")
    public @ResponseBody String getData() {
        return labService.getData();
    }
    @GetMapping("/data/params/{val1}")
    public @ResponseBody String getDataWithParams(@PathVariable String val1, @RequestParam String val2)
            {
        return labService.GetDataWithParams(val1,val2);
    }

    @GetMapping("/factorial")
    public @ResponseBody long GetDataForFact (@RequestParam long val)
             {
        return labService.GetDataForFact(val);
    }

    @GetMapping("/rootsquare")
    public @ResponseBody double GetDataForNumberSquare (@RequestParam int val)
    {
        return labService.GetDataForRootSquare(val);
    }

    @GetMapping("/anyfunction")
    public @ResponseBody double GetDataForAnyFunction (@RequestParam int val1, @RequestParam int val2)
    {
        return labService.GetDataForAnyFunction(val1,val2);
    }
    @PostMapping("/save")
    public @ResponseBody void save(@RequestBody LabTable labTable){
        labService.save(labTable);
    }

    @GetMapping("/get")
    public  @ResponseBody List<LabTable> GetEntity(){
        return labService.findAll();
    }
    @PutMapping("/update/id")
    public @ResponseBody void UpdateById(@RequestParam long id, @RequestParam String name) {
         labService.update(id,name);
    }

    @GetMapping("/get/name")
    public @ResponseBody List<LabTable> GetEntitiesByName(@RequestParam String name) {
        return labService.findAllByName(name);
    }

    @DeleteMapping("delete/id")
    public  @ResponseBody void DeleteById (@RequestParam long id){
        labService.deleteById(id);
    }
}
