	@RequestMapping(params = { "method=batchDownloadQRcode" })
	@ResponseBody()
	public String batchDownloadQRcode(ModelMap model, QRCodeInfo qRCodeInfo,
			HttpServletResponse response) {
		StatusInfoCodeType codeType = StatusInfoCodeType.ok;
		StatusInfoEntity statusInfoEntity = new StatusInfoEntity();
		statusInfoEntity.setTabid("resourceList");
		statusInfoEntity.setMessage("成功");
		statusInfoEntity.setCloseCurrent(true);
		ServletOutputStream output = null;
		File file = null;
		try {
			output = response.getOutputStream();
			response.setHeader("content-disposition", "attachment;filename="
					+ URLEncoder.encode("批量", "UTF-8") + ".zip");
			List<QRCodeInfo> list = qRCodeInfoService.queryByStatus(qRCodeInfo);
			if (CollectionUtil.isNotEmpty(list)) {
				file = qRCodeInfoService.getZipFile(list);
				downloadFile(output, file);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			statusInfoEntity.setMessage("下载二维码信息失败!");
			codeType = StatusInfoCodeType.error;
		} finally {
			try {
				output.close();
				if (file != null) {
					// file.deleteOnExit();
					file.delete();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return getStatusInfo(statusInfoEntity, codeType);
	}