package com.huoli.enableload.annotation.services;

import com.huoli.enableload.annotation.filecontent.FileContent;
import com.huoli.enableload.annotation.utilEntity.ResultIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileServiceImpl implements FileService{
    @Override
    public List<ResultIndex> getFileData() {
        FileContent fileContent = new FileContent();
        List<ResultIndex> result = new ArrayList<>();
        Map<String, List<String>> urlResult = fileContent.getUrls();
        Set<String> keySet = urlResult.keySet();
        for (String key : keySet) {
//            result.add(new ResultIndex().builder().interfaces(key).impl(urlResult.get(key)).build());
            ResultIndex resultIndex = new ResultIndex();
            resultIndex.setInterfaces(key);
            resultIndex.setImpl(urlResult.get(key));
            result.add(resultIndex);
        }
        return result;
    }
}
