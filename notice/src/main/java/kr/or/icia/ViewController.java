package kr.or.icia;

import java.util.List;

import javax.annotation.Resource;

import kr.or.icia.dao.BbsDao;
import kr.or.icia.dao.BbsVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value = "viewController")
public class ViewController {
 
    // Resource 어노테이션을 이용하여 BbsDao 선언.
    @Resource(name = "bbsDao")
    private BbsDao bbsDao;
 
    // 게시판 목록
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dispBbsList(Model model) {
        List<BbsVo> list = this.bbsDao.getSelect();
        model.addAttribute("list", list);
        return "bbs.list";
    }
 
    // 게시판 상세보
    @RequestMapping("/{idx}")
    public String dispBbsView(@PathVariable int idx, Model model) {
        BbsVo object = this.bbsDao.getSelectOne(idx);
        model.addAttribute("object", object);        
        return "bbs.view";
    }
 
    // 게시판 쓰기
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String dispBbsWrite(@RequestParam(value="idx", 
                                    defaultValue="0") int idx, Model model) {
        if (idx > 0) {
            BbsVo object = this.bbsDao.getSelectOne(idx);
            model.addAttribute("object", object);
        }
        return "bbs.write";
    }
 
    @RequestMapping(value = "/write_ok", method = RequestMethod.POST)
    public String procBbsWrite(@ModelAttribute("bbsVo") BbsVo bbsVo, 
                                    RedirectAttributes redirectAttributes) {
        Integer idx = bbsVo.getIdx();
 
        if (idx == null || idx == 0) {
            this.bbsDao.insert(bbsVo);
            redirectAttributes.addFlashAttribute("message", "추가되었습니다.");
            return "redirect:/";
        } else {
            this.bbsDao.update(bbsVo);
            redirectAttributes.addFlashAttribute("message", "수정되었습니다.");
            return "redirect:/write?idx=" + idx;
        }
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String procBbsDelete(@RequestParam(value = "idx", required = false) int idx) {
        this.bbsDao.delete(idx);
        return "redirect:/";
    }
}
