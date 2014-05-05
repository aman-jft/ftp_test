package ftptest

class TransferController {

    def ftpFileTransferService
    def index = {
        render view: '/index'
    }
    def download = {
       // flash.message = ftpFileTransferService.download()
        flash.message ='order.geninvoice.success'
        flash.args = ['testing number']
        redirect(uri: '/')
    }

    def upload() {
        println "${params.path}--------------"
        println "==========Aman=========revert 1"
        String path = params.path ?: "/home/aman/test/"
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(params.type);
            }
        };
        File[] fileList = new File(path).listFiles(filter);
        flash.message = ftpFileTransferService.upload(fileList)
        redirect(uri: '/')
    }

    def test(){
        render "hello"
    }
}
